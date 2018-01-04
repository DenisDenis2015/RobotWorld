package by.rudenko.testproject.robotpool;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.RobotType;

/**
 * RobotPool - contains robots.
 */
@Component
public class RobotPool {
	
	private List<Robot> robots;
	
	private Map<RobotType, Long> robotPoolConfig;
	
	@Autowired
	public Function<RobotType,  ? extends Robot> robotFactory;

	public List<? extends Robot> getRobots() {
		return robots;
	}
	
	public Map<RobotType, Long> getRobotPoolInitConfig() {
        return robotPoolConfig;
    }

    @PostConstruct
    public void initRobot() {
	    robots = new CopyOnWriteArrayList<>();
        robots.add(robotFactory.apply(RobotType.FAST));
        robots.add(robotFactory.apply(RobotType.FAST));
        robots.add(robotFactory.apply(RobotType.LAZY));
        robots.add(robotFactory.apply(RobotType.LAZY));
        saveRobotPoolConfiguration();
    }
	
	private void saveRobotPoolConfiguration() {
	    robotPoolConfig = Collections.unmodifiableMap(getCurrentPollConfig());
        
    }

	public Map<RobotType, Long> getCurrentPollConfig() {
		return robots.stream().
		    collect(Collectors.groupingBy(r -> r.getType(), Collectors.counting()));
	}

    public Robot addRobot(RobotType type){
    	Robot robot = robotFactory.apply(type);
		robots.add(robot);
		return robot;
	}
}
