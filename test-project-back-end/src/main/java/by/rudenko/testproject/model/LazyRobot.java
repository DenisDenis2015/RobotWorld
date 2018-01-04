package by.rudenko.testproject.model;

import java.util.Random;

import by.rudenko.testproject.service.ReportService;
import by.rudenko.testproject.work.LazyWork;

/**
 * LazyRobot do lazy work.
 */
public class LazyRobot extends Robot {

	public LazyRobot(ReportService reportService) {
		this.id = "LazyRobot" + new Random().nextInt(500);
		this.type = RobotType.LAZY;
		this.work = new LazyWork(reportService);
	}

}
