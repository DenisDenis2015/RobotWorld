package by.rudenko.testproject.factory;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import by.rudenko.testproject.model.FastRobot;
import by.rudenko.testproject.model.LazyRobot;
import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.RobotType;
import by.rudenko.testproject.service.ReportService;

@EnableAutoConfiguration
public class RobotFactory {
	
    @Autowired
    private ReportService reportService;
    
    /**
     * Creating a new robot by type.
     */
    @Bean
    public Function<RobotType, ? extends Robot> robotFactory() {
        return this::createRobot;
    }

    @Bean
    @Scope(value = "prototype")
    @DependsOn(value = {"reportService"})
    public Robot createRobot(RobotType robotType) {
        if (RobotType.FAST.equals(robotType) || (RobotType.ANY.equals(robotType))) {
            return new FastRobot(reportService);
        } else if (RobotType.LAZY.equals(robotType)) {
            return new LazyRobot(reportService);
        } else {
            throw new UnsupportedOperationException("unknow robot type :" + robotType);
        }
    }
}
