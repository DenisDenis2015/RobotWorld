package by.rudenko.testproject.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.RobotType;
import by.rudenko.testproject.model.Task;
import by.rudenko.testproject.model.TaskType;
import by.rudenko.testproject.service.ReportService;
import by.rudenko.testproject.service.RobotService;
import by.rudenko.testproject.service.TerminalService;

@Service
public class TerminalServiceImpl implements TerminalService {

	@Autowired
	private RobotService robotService;

	@Autowired
	private ReportService reportService;

	@Override
	public void acceptTask(Task task) {

		if (task.getTaskType().equals(TaskType.DO)) {

			acceptTaskTypeDo(task);

		} else if (task.getTaskType().equals(TaskType.DOALL)) {

			acceptTaskForAllRobot(task);

		} else if (task.getTaskType().equals(TaskType.DELETE)) {
			deleteRobot(task.getRobotId());
		}
	}

	@Override
	public void acceptTaskTypeDo(Task task) {

		if (StringUtils.isNotBlank(task.getRobotId())) {
			
			if (robotService.checkIfRobotExist(task.getRobotId())) {
				
				robotService.doWorkByRobotId(task);
				
			} else {
				
				reportService.publishMessage("cannot found robot with id  : " + task.getRobotId());
				
			}


		} else if (task.getRobotType().equals(RobotType.ANY)) {
		    
		    long freeRobots = robotService.checkHowManyRobotsIsFree();

			checkFreeRobot(task, freeRobots);

			robotService.doWorkAnyRobot(task);

		} else {
		    
		    long freeRobots = robotService.checkHowManyRobotsIsFreeByType(task.getRobotType());

			checkFreeRobot(task, freeRobots);

			robotService.doWorkByRobotType(task);
		}

	}

	@Override
	public void acceptTaskForAllRobot(Task task) {
		robotService.doAllWork(task);
	}

	@Override
	public void deleteRobot(String id) {
		
		boolean deleteRobot = robotService.deleteRobot(id);
		
		if (deleteRobot) {
			reportService.publishMessage("robot with id : " + id + " deleted");
		} else {
			reportService.publishMessage("cannot found robot with id : " + id);
		}
	}

	private void checkFreeRobot(Task task, long freeRobots) {

		if (freeRobots == 0) {

			reportService.publishMessage("all robots is busy, create new robot");

			Robot addRobot = robotService.addRobot(task.getRobotType());

			reportService.publishMessage("new robot was added : " + addRobot);
		}
	}

	@Override
	public void serviceRobotPool() {
	    
	    Map<RobotType, Long> robotNeedToCreate = robotService.checkInitRobotPool();
	    
        for (Map.Entry<RobotType, Long> value : robotNeedToCreate.entrySet()) {
            
            if (value.getValue() > 0) {
                
                Robot addRobot = robotService.addRobot(value.getKey());
                
                reportService.publishMessage("ScheduledTasks added new robot : " + addRobot);
                
            }

        }
		
	}
}
