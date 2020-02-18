package com.dt.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dt.core.util.UserUtil;
import com.dt.service.XzEpidemicSituationService;

@Component
@SpringBootConfiguration // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class ScheduleTask {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private XzEpidemicSituationService xzEpidemicSituationService;
   //查看上下线情况
	@Scheduled(cron = "0 */10 * * * ?")
	private void updateYQ() {
		log.info("==========开始更新疫情============"+UserUtil.getNowStrTime("yyyy-MM-dd HH:mm:ss"));
		xzEpidemicSituationService.updateYQ();
		log.info("《《《《《《《结束更新疫情》》》》》》》》");
	}
}
