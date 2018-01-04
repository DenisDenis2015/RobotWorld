package by.rudenko.testproject.model;

import java.util.concurrent.atomic.AtomicBoolean;

import by.rudenko.testproject.work.Work;

/**
 * Parent class for robot.
 */
public abstract class Robot {
	
	protected String id;
	protected RobotType type;
	protected AtomicBoolean isBusy = new AtomicBoolean(false);
	protected Work work;

	public String getId() {
		return id;
	}

	public RobotType getType() {
		return type;
	}

	public boolean isBusy() {
		return isBusy.get();
	}

	public void setBusy(boolean busy) {
		this.isBusy.set(busy);
	}
	
	public void doWork(Task task){
	    work.doWork(this, task);
	}

    @Override
    public String toString() {
        return "Robot id=" + id;
    }
	
}
