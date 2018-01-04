package by.rudenko.testproject.model;

import java.util.Random;

import by.rudenko.testproject.service.ReportService;
import by.rudenko.testproject.work.FastWork;

/**
 * FastRobot do fast work.
 *
 */
public class FastRobot extends Robot {
    
    public FastRobot(ReportService reportService) {
        this.id = "FastRobot" + new Random().nextInt(500);
        this.type = RobotType.FAST;
        this.work = new FastWork(reportService);
    }
    
}
