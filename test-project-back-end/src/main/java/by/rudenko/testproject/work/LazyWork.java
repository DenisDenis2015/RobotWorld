package by.rudenko.testproject.work;

import org.apache.log4j.Logger;

import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.Task;
import by.rudenko.testproject.service.ReportService;

public class LazyWork extends Work {

	Logger logger = Logger.getLogger(LazyWork.class);

	public LazyWork(ReportService reportService) {
		this.reportService = reportService;
	}

	private ReportService reportService;

	@Override
	public synchronized void work(Robot robot, Task task) {

		robot.setBusy(true);

		try {

			reportService.publishMessage(robot.toString() + " begin " + task.toString());

			Thread.sleep(20_000);

			reportService.publishMessage(robot.toString() + " end " + task.toString());

		} catch (InterruptedException e) {
			logger.error(e.getStackTrace());
			reportService.publishMessage(e.getMessage());
		} finally {
			robot.setBusy(false);
		}

	}

}
