package by.rudenko.testproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.rudenko.testproject.model.FastRobot;
import by.rudenko.testproject.model.LazyRobot;
import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.RobotType;
import by.rudenko.testproject.service.ReportService;
import by.rudenko.testproject.service.RobotFactory;

@Service
public class RobotFactoryImpl implements RobotFactory {
	
    @Autowired
    private ReportService reportService;
    
    /**
     * Creating a new robot by type.
     */
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
