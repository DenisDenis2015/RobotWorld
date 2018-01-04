package by.rudenko.testproject.work;

import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.Task;

/**
 * Parent class for work.
 */
public abstract class Work {

	public final void doWork(Robot robot, Task task) {
		new Thread(() -> work(robot, task)).start();
	};

	protected abstract void work(Robot robot, Task task);

}
