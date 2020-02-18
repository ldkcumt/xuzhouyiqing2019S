package com.dt.core.util;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;



public class UserUtil
{
	private static Logger log = Logger.getLogger(UserUtil.class);
	// 用来全局控制 上一周，本周，下一周的周数变化
	private static int weeks = 0;
	private static int MaxDate;// 一月最大天数
	private static int MaxYear;// 一年最大天数
	public static final int Maxraidus =2000;//搜索半径：2千米
	public static final int Maxraidus1 =5000;//搜索半径：5千米
	public static int weather_count =0;
	/**
	 * 生成以中心点为中心的四方形经纬度
	 * 
	 * @param lat
	 *            纬度
	 * @param lon
	 *            精度
	 * @param raidus
	 *            半径（以米为单位）
	 * @return
	 */
	public static double[] getAround(double lat, double lon, int raidus)
	{
		Double latitude = lat;
		Double longitude = lon;

		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLng, minLat, maxLng, maxLat, lon, lat };
	}

	/**
	 * 计算中心经纬度与目标经纬度的距离（千米）
	 * 
	 * @param centerLon
	 *            中心经度
	 * @param centerLan
	 *            中心纬度
	 * @param targetLon
	 *            目标经度
	 * @param targetLan
	 *            目标纬度
	 * @return 千米
	 */
	public static double distance(double centerLon, double centerLan,
			double targetLon, double targetLan)
	{

		double jl_jd = 102834.74258026089786013677476285;// 每经度单位米;
		double jl_wd = 111712.69150641055729984301412873;// 每纬度单位米;
		double b = Math.abs((centerLan - targetLan) * jl_wd);
		double a = Math.abs((centerLon - targetLon) * jl_jd);
		double f = (Math.sqrt((a * a + b * b))) / 1000;
		BigDecimal big = new BigDecimal(f);
		double fd = big.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return fd;
		// return Math.sqrt((a * a + b * b));
	}

	public static String getSendContent(Integer type)
	{
		String content = "";
		switch (type)
		{
		case 18:
			content = "已经把你加入了客户列表，快来看看，立即下载";
			break;
		case 19:
			content = "已经把你加入了家人列表，快来看看，立即下载";
			break;
		case 20:
			content = "已经把你加入了同事列表，快来看看，立即下载";
			break;
		default:
			content = "";
			break;
		}
		return content;
	}

	
	public static String setNulltoStr(Object str)
	{
		return str == null ? "" :str.toString();
	}
	
	//检查时空码不能包含下列字符串
	public static Integer checkUserCode(String code)
	{
		if(code.indexOf("000") > 0)
		{
			return -1;
		}
		if(code.indexOf("111") > 0)
		{
			return -1;
		}
		if(code.indexOf("222") > 0)
		{
			return -1;
		}
		if(code.indexOf("333") > 0)
		{
			return -1;
		}
		if(code.indexOf("444") > 0)
		{
			return -1;
		}
		if(code.indexOf("555") > 0)
		{
			return -1;
		}
		if(code.indexOf("666") > 0)
		{
			return -1;
		}
		if(code.indexOf("777") > 0)
		{
			return -1;
		}
		if(code.indexOf("888") > 0)
		{
			return -1;
		}
		if(code.indexOf("999") > 0)
		{
			return -1;
		}
		if(code.equals("12345"))
		{
			return -1;
		}
		if(code.equals("123456"))
		{
			return -1;
		}
		if(code.equals("1234567"))
		{
			return -1;
		}
		if(code.equals("12345678"))
		{
			return -1;
		}
		if(code.equals("123456789"))
		{
			return -1;
		}
		return 0;
	}
	
	/**
	 * 得到二个日期间的间隔天数
	 * sj1结束时间
	 * sj2开始时间
	 */
	public static long getTwoDay(String sj1, String sj2)
	{
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try
		{
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e)
		{
			return 0;
		}
		
		return day;
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate)
	{
		// 再转换为时间
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2)
	{
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date mydate = null;
		try
		{
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e)
		{
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	// 计算当月最后一天,返回字符串
	public static String getDefaultDay()
	{
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 上月第一天
	public static String getPreviousMonthFirst()
	{
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获取当月第一天
	public static String getFirstDayOfMonth()
	{
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得本周星期日的日期
	public static String getCurrentWeekday()
	{
		weeks = 0;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获取当天时间
	public static Date getNowTime()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		Date currDate=null;
		try
		{
			currDate = format.parse(format.format(now));
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currDate;
	}

	// 获取现在时间
	public static Timestamp getNowTime(String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date now = new Date();
		Date currDate = null;
		Timestamp nousedate=null;
		try {
			currDate = format.parse(format.format(now));
			nousedate = new Timestamp(currDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nousedate;
	}

	// 获取现在时间
	public static String getNowStrTime(String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date now = new Date();
		String currDate = null;
		try {
			currDate = format.format(now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currDate;
	}
	// 获得当前日期与本周日相差的天数
	private static int getMondayPlus()
	{
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1)
		{
			return 0;
		} else
		{
			return 1 - dayOfWeek;
		}
	}

	// 获得本周一的日期
	public static String getMondayOFWeek()
	{
		weeks = 0;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得相应周的周六的日期
	public static String getSaturday()
	{
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得上周星期日的日期
	public static String getPreviousWeekSunday()
	{
		weeks = 0;
		weeks--;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得上周星期一的日期
	public static String getPreviousWeekday()
	{
		weeks--;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得下周星期一的日期
	public static String getNextMonday()
	{
		weeks++;
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得下周星期日的日期
	public static String getNextSunday()
	{

		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	private static int getMonthPlus()
	{
		Calendar cd = Calendar.getInstance();
		int monthOfNumber = cd.get(Calendar.DAY_OF_MONTH);
		cd.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		cd.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		MaxDate = cd.get(Calendar.DATE);
		if (monthOfNumber == 1)
		{
			return -MaxDate;
		} else
		{
			return 1 - monthOfNumber;
		}
	}

	// 获得下个月第一天的日期
	public static String getNextMonthFirst()
	{
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得下个月最后一天的日期
	public static String getNextMonthEnd()
	{
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 加一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得明年最后一天的日期
	public static String getNextYearEnd()
	{
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		lastDate.roll(Calendar.DAY_OF_YEAR, -1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得明年第一天的日期
	public static String getNextYearFirst()
	{
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		str = sdf.format(lastDate.getTime());
		return str;

	}

	// 获得本年有多少天
	private static int getMaxYear()
	{
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		return MaxYear;
	}

	private static int getYearPlus()
	{
		Calendar cd = Calendar.getInstance();
		int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		if (yearOfNumber == 1)
		{
			return -MaxYear;
		} else
		{
			return 1 - yearOfNumber;
		}
	}

	// 获得本年第一天的日期
	public static String getCurrentYearFirst()
	{
		int yearPlus = getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, yearPlus);
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		return preYearDay;
	}

	// 获得本年最后一天的日期 *
	public static String getCurrentYearEnd()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		return years + "-12-31";
	}

	// 获得上年第一天的日期 *
	public static String getPreviousYearFirst()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);
		years_value--;
		return years_value + "-1-1";
	}

	// 获得上年最后一天的日期
	public static String getPreviousYearEnd()
	{
		weeks--;
		int yearPlus =getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, yearPlus + MaxYear * weeks
				+ (MaxYear - 1));
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		getThisSeasonTime(11);
		return preYearDay;
	}

	// 获得本季度
	public static String getThisSeasonTime(int month)
	{
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3)
		{
			season = 1;
		}
		if (month >= 4 && month <= 6)
		{
			season = 2;
		}
		if (month >= 7 && month <= 9)
		{
			season = 3;
		}
		if (month >= 10 && month <= 12)
		{
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days
				+ ";" + years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	/**
	 * 获取某年某月的最后一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 最后一天
	 */
	private static int getLastDayOfMonth(int year, int month)
	{
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12)
		{
			return 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11)
		{
			return 30;
		}
		if (month == 2)
		{
			if (isLeapYear(year))
			{
				return 29;
			} else
			{
				return 28;
			}
		}
		return 0;
	}

	/**
	 * 是否闰年
	 * 
	 * @param year
	 *            年
	 * @return
	 */
	public static boolean isLeapYear(int year)
	{
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	/** 修改日期天数
	* @param baseDate 基准日期String (格式yyyyMMdd)
	* @param amount 要增加的天数（负数为减）
	* @return 基准日期增加或减少若干天后的日期 
	 * @throws ParseException 
	*/
	public static Date dateModify(String baseDate,int amount )
	{
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); // 将字符串格式化
	   Date dt=sdf.parse(baseDate,new ParsePosition(0)); // 由格式化后的字符串产生一个Date对象
	  
	   Calendar c = Calendar.getInstance(); // 初始化一个Calendar
	   c.setTime(dt); // 设置基准日期
	   c.add(Calendar.DATE, amount); //你要加减的日期 
	   Date dt1=c.getTime(); // 从Calendar对象获得基准日期增减后的日期
	   Date sb=null;
		try
		{
			sb = sdf.parse(sdf.format(dt1));
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 得到结果字符串
	   return sb;
	}
	
	//根据文件类型获取相应的容量
	//0.视频1.音频2.图片3.文字5.其它
	public static Integer getVolume(Short type)
	{
		Integer num = 0;
		switch (type)
		{
		case 0:
			num = 4;
			break;
		case 1:
			num = 1;
			break;
		case 2:
			num = 1;
			break;
		case 3:
			num = 1;
			break;
		default:
			num = 0;
			break;
		}
		return num;
	}
	
	//0.时间未到1.超出2公里2.打开
	public static int getIsOpen(long startnum,long endnum,double longitudeUser,double latitudeUser,double longitude,double latitude)
	{
		Date currdaet = getNowTime();
		int rtn =0;
		if(currdaet.getTime() >= startnum && currdaet.getTime() <= endnum)
		{
			rtn=1;
			double userDistance = UserUtil.distance(longitudeUser,latitudeUser,longitude, latitude);
			if(userDistance <= 2)
			{
				rtn = 2;
			}
		}
		return rtn;
	}
	
	public static boolean getMapIsValue(HashMap<Integer,Integer> map,int value)
	{
		if(map.get(value) != null && map.get(value) > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
    public synchronized static String getLivePathStr(){
   
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		Date now = new Date();
		String str="";
		try {
	        // 给定模式
			str = format.format(now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return str;
    }
    public synchronized static String getSerialStr(){
    	   
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date now = new Date();
		String str="";
		try {
	        // 给定模式
			str = format.format(now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return str;
    }
    public synchronized static String getDaySerialStr(){
 	   
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String str="";
		try {
	        // 给定模式
			str = format.format(now);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return str;
    }
    public synchronized static String getTimeFormatStr(Timestamp time,String format1){
		SimpleDateFormat format = new SimpleDateFormat(format1);
		String str="";
		try {
	        // 给定模式
			str = format.format(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return str;
    }

	private static boolean isNotEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
				|| (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
				|| ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}

	public static String filterEmoji(String source) {
		int len = source.length();
		StringBuilder buf = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (isNotEmojiCharacter(codePoint)) {
				buf.append(codePoint);
			} else {

				buf.append("*");

			}
		}
		return buf.toString();
	}

	/**
	 * @note 删除文件或者目录下的所有文件
	 * @param path
	 * @return
	 */
	public static boolean delFile(String path) {
		if (StringUtils.isBlank(path)) {
			return false;
		}
		File file = new File(path);
		if (!file.exists()) {
			return false;
		}
		try {
			if (file.isDirectory()) {
				String[] tempList = file.list();
				if(tempList.length>0){
					File temp = null;
					for (int i = 0; i < tempList.length; i++) {
						if (path.endsWith(File.separator)||path.endsWith("/")) {
							temp = new File(path + tempList[i]);
						} else {
							temp = new File(path + File.separator + tempList[i]);
						}
						if (temp.isFile()) {
							temp.delete();
						}
						if (temp.isDirectory()) {
							delFile(path + File.separator + tempList[i]);// 先删除文件夹里面的文件
							//删除空文件夹
							temp.delete();
						}
					}
					//检查是否空了，空了将文件夹删除
					if(file.list().length<1){
						//删除空文件夹
						file.delete();
					}
				}else{
					//删除空文件夹
					file.delete();
				}
				
			} else {
				file.delete();
				if(file.getParentFile().isDirectory()&&file.getParentFile().list().length<1){
					file.getParentFile().delete();
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public static String get4Uuid()
	{
		Random r = new Random();
		StringBuilder uuidstr = new StringBuilder(String.valueOf(r.nextFloat()));
		uuidstr.delete(0, 2);
		if(uuidstr.length()>4){
			uuidstr.delete(4, uuidstr.length());
		}
		if(uuidstr.length()<4){
			for(int i=uuidstr.length(); i<4;i++){
				uuidstr.append(String.valueOf(r.nextInt(10)));
			}
		}
		return uuidstr.toString();
	} 
	public static String getTimeFormat1(String time, String formatStr) {
		try{
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		ParsePosition pos = new ParsePosition(0);
		String strtodate = format.format(format.parse(time, pos));
		return strtodate;
		}catch(Exception e){
			return null;
		}
		
	}
	public static Timestamp getTimeFormat(String time, String formatStr) {
		try{
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = format.parse(time, pos);
		Timestamp nousedate = new Timestamp(strtodate.getTime());
		return nousedate;
		}catch(Exception e){
			return null;
		}
		
	}
	public static boolean isInteger(String str) {
		if (str != null && !"".equals(str)) {
			Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
			return pattern.matcher(str).matches();
		} else {
			return false;
		}

	}
	public static boolean isNumeric(String str) {
		if(StringUtils.isBlank(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");// 这个是对的
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}else {
			return true;
		}
		
	}
	public static String getTimeFormatStr(Date time, String format1) {
		SimpleDateFormat format = new SimpleDateFormat(format1);
		String str = "";
		try {
			// 给定模式
			str = format.format(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public static String getPreviousMonth(int month) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -month);// 减一个月
		str = sdf.format(lastDate.getTime());
		return str;
	}
	public static String splitFileName(String accessUrl) {
		if(StringUtils.isNotBlank(accessUrl)) {
			int index=accessUrl.lastIndexOf("/");
			String name=accessUrl.substring(index+1);
			return name;
		}else {
			return null;
		}
	}

	// 获得下个月第一天的日期
	public static String getYesterday() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.DATE,-1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	public static void main(String[] args) {
//		System.out.println(splitFileName("http://139.129.23.185:8080/kcvideo/111.png"));
		System.out.println(getYesterday());
	}

}
