package by.rudenko.testproject.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.RobotType;
import by.rudenko.testproject.model.Task;
import by.rudenko.testproject.robotpool.RobotPool;
import by.rudenko.testproject.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService{
	
	@Autowired
	private RobotPool robotPool;

	@Override
	public void doWorkByRobotId(Task task) {
		robotPool.getRobots().stream()
			.filter(r -> r.getId().equals(task.getRobotId()))
			.findFirst()
			.ifPresent(r -> r.doWork(task));
	}
	
   @Override
    public void doWorkByRobotType(Task task) {
        robotPool.getRobots().stream()
            .filter(r -> r.getType().equals(task.getRobotType()) && !r.isBusy())
            .findFirst()
            .ifPresent(r -> r.doWork(task));
    }
   
	@Override
	public void doWorkAnyRobot(Task task) {
		robotPool.getRobots().stream()
		.filter(r -> !r.isBusy())
		.findFirst()
		.ifPresent(r -> r.doWork(task));
	}

	@Override
	public void doAllWork(Task task) {
		robotPool.getRobots()
		    .parallelStream()
		    .forEach(r -> r.doWork(task));
	}

    @Override
    public long checkHowManyRobotsIsFreeByType(RobotType type) {
        return robotPool.getRobots()
            .stream()
            .filter(r -> r.getType().equals(type) && !r.isBusy())
            .count();
    }
    
    @Override
    public long checkHowManyRobotsIsFree() {
        return robotPool.getRobots()
            .stream()
            .filter(r -> !r.isBusy())
            .count();
    }
    
    @Override
    public long getRobotCount(){
        return robotPool.getRobots().size();
    }

	@Override
	public Robot addRobot(RobotType type) {
		return robotPool.addRobot(type);
	}

	@Override
	public boolean deleteRobot(String id) {
		return robotPool.getRobots().removeIf(r -> r.getId().equals(id));
	}

	@Override
	public boolean checkIfRobotExist(String id) {
		return robotPool.getRobots().stream()
				.anyMatch(r -> r.getId().equals(id));
	}

	@Override
	public Map<RobotType, Long> checkInitRobotPool() {
		
		Map<RobotType, Long> robotPoolInitConfig = robotPool.getRobotPoolInitConfig();
		
		Map<RobotType, Long> currentPollConfig = robotPool.getCurrentPollConfig();
		
		Map<RobotType, Long> result = new HashMap<>();
		
        for (Map.Entry<RobotType, Long> value : robotPoolInitConfig.entrySet()) {
            
            Long robotCountInCurrentPoolConfig = currentPollConfig.get(value.getKey());
            
            Long robotNeedToCreate = value.getValue() - robotCountInCurrentPoolConfig;
            
            result.put(value.getKey(), robotNeedToCreate);

        }
        
        return result;
	}
}
