package by.rudenko.testproject.scheduler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import by.rudenko.testproject.service.TerminalService;

@Component
public class ScheduledTasks {
	
	private Logger logger = Logger.getLogger(ScheduledTasks.class);
	
	@Autowired
	private TerminalService terminalService;

    @Scheduled(fixedRate = 30000)
    public void checkInitRobotPool() {
    	logger.info("begin ScheduledTasks checkInitPool...");
    	terminalService.serviceRobotPool();
    }

}
