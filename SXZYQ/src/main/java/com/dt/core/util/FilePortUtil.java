package com.dt.core.util;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @author zl
 *
 */

public class FilePortUtil {
	private static final Logger log = LoggerFactory.getLogger(FilePortUtil.class);

	/**
	 * 导出功能 注意：泛型T类字段名和containBean集合里字段名字的一致性
	 *
	 * @param response
	 * @param title       表名
	 * @param headers     表头
	 * @param list        数据集
	 * @param containBean 数据集类型字段
	 * @param <T>
	 * @throws Exception
	 */
	public static <T> void exportExcel(HttpServletResponse response, String title, String[] headers, List<T> list,
			String[] containBean) throws Exception {
		HSSFWorkbook workbook = null;
		OutputStream os = null;
		try {
			workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(title);
			HSSFRow row = sheet.createRow(0);
			/* 创建第一行表头 */
			for (short i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			Iterator<T> it = list.iterator();
			int index = 0;
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T t = (T) it.next();
				/* 反射得到字段 */
				Field[] fields = t.getClass().getDeclaredFields();
				/* 如果需要匹配 */
				if (containBean != null) {
					for (int j = 0; j < containBean.length; j++) {
						for (int i = 0; i < fields.length; i++) {
							Field field = fields[i];
							if (!field.getName().equals(containBean[j]))
								continue;
							/* 给每一列set值 */
							setCellValue(t, field, row, j);
						}
					}
				} else {
					for (int i = 0; i < fields.length; i++) {
						Field field = fields[i];
						setCellValue(t, field, row, i);
					}
				}
			}
			/* application/vnd.ms-excel告诉浏览器要下载的是个excel */
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			/* 请求头设置，Content-Disposition为下载标识，attachment标识以附件方式下载 */
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String((title).getBytes(), "ISO8859-1") + ".xls");
			os = response.getOutputStream();
			workbook.write(os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.flush();
				os.close();// 不关闭会报错文件损坏错误
			}
			if (workbook != null) {
				workbook.close();
			}
		}
	}

	/**
	 * 设置每一行中的列
	 *
	 * @param t
	 * @param field
	 * @param row
	 * @param index
	 * @param <T>
	 */
	private static <T> void setCellValue(T t, Field field, HSSFRow row, int index) {
		HSSFCell cell = row.createCell(index);
		Object value = invoke(t, field);
		String textValue = null;
		if (value != null) {
			if (value instanceof Date) {
				Date date = (Date) value;
				textValue = UserUtil.getTimeFormatStr(date, "yyyy-MM-dd HH:mm:ss");
			} else {
				textValue = value.toString();
			}
		}
		if (textValue != null) {
			cell.setCellValue(textValue);
		}
	}

	/**
	 * 反射映射数据集字段
	 *
	 * @param t
	 * @param field
	 * @param <T>
	 * @return
	 */
	private static <T> Object invoke(T t, Field field) {
		try {
			String fieldName = field.getName();
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, t.getClass());
			Method method = pd.getReadMethod();
			// 写入属性值的方法
//            Method writeMethod=pd.getWriteMethod();
//            writeMethod.invoke(t, "wrong");
			return method.invoke(t);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 反射映射数据集字段--写入
	 *
	 * @param t
	 * @param field
	 * @param <T>
	 * @return
	 */
	private static <T> T invokeWrite(T t, String[] headers, Row row) {
		try {
			for (int i = 0; i < headers.length; i++) {
				String fieldName = headers[i];
				PropertyDescriptor pd = new PropertyDescriptor(fieldName, t.getClass());
				Method writeMethod = pd.getWriteMethod();
				Class<?> type = pd.getPropertyType();
				if (java.lang.Double.class.isAssignableFrom(type)) {
					Double param = getCellDoubleValue(row.getCell(i));
					writeMethod.invoke(t, param);
				} else if (java.lang.Integer.class.isAssignableFrom(type)) {
					Integer param = getCellIntegerValue(row.getCell(i));
					writeMethod.invoke(t, param);
				} else {
					String param = getCellStringValue(row.getCell(i));
					writeMethod.invoke(t, param);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 导出功能 注意：泛型T类字段名和containBean集合里字段名字的一致性
	 *
	 * @param response
	 * @param title       表名
	 * @param headers     表头
	 * @param list        数据集
	 * @param containBean 数据集类型字段
	 * @param <T>
	 * @throws Exception
	 */
	public static <T> List<T> importExcel(MultipartFile multipartFile, Class<T> t, String[] containBean)
			throws Exception {
		// TODO Auto-generated method stub
		if (!multipartFile.getOriginalFilename().endsWith("xlsx")
				&& !multipartFile.getOriginalFilename().endsWith("xls")) {
			return null;
		}
		File file = null;
		Workbook workbook = null;
		String path = FilePortUtil.class.getClassLoader().getResource("/").getPath();
		path = path.substring(0, path.indexOf("WEB-INF") + "WEB-INF".length()) + "/"
				+ multipartFile.getOriginalFilename();
		file = new File(path);
		List<T> list = new ArrayList<T>();
		try {
			/* 把文件流copy读取到文件中 */
			FileCopyUtils.copy(multipartFile.getBytes(), file);
			workbook = WorkbookFactory.create(new FileInputStream(file));

			/* 遍历sheet页 */
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				if (sheet == null) {
					continue;
				}
				/* 统计导入的总条数，要是你的excell包含了表头，就不用加1了 */
//				if (sheet.getLastRowNum() > 0) {
//					totalNum = sheet.getLastRowNum();
//				}
				/* 遍历行，这里j的初始值取1是因为我的表格里第一行是表头 */
				for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
					Row row = sheet.getRow(j);
					// 通过反射机制设置属性值
					T model = t.newInstance();
					T res = (T) invokeWrite(model, containBean, row);

					list.add(res);

				}

			}
			/* 解析完删除此路径下的文件 */
			file.delete();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Double getCellDoubleValue(Cell cell) {
		if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return null;
		}
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			Double d = cell.getNumericCellValue();
			return d;
		} else {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String cellValue = cell.getStringCellValue();
			try {
				Double value = Double.valueOf(cellValue.trim());
				return value;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

	}

	public static Integer getCellIntegerValue(Cell cell) {
		if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return null;
		}
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			Double d = cell.getNumericCellValue();
			return d.intValue();
		} else {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String cellValue = cell.getStringCellValue();
			try {
				Integer value = Integer.valueOf(cellValue.trim());
				return value;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public static Boolean getCellBooleanValue(Cell cell) {
		if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return null;
		}
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return cell.getBooleanCellValue();
		} else {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String cellValue = cell.getStringCellValue();
			try {
				Boolean value = Boolean.valueOf(cellValue.trim());
				return value;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public static String getCellStringValue(Cell cell) {
		if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return null;
		}
		cell.setCellType(Cell.CELL_TYPE_STRING);
		return cell.getStringCellValue();

	}
}
