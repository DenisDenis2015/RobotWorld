package by.rudenko.testproject.model;

/**
 * Task for robot {@link by.rudenko.testproject.model.Robot} 
 */
public class Task {
	
	private int taskId;
	private String robotId;
	private String taskToDo;
	private RobotType robotType;
	private TaskType taskType;
	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @return the robotId
	 */
	public String getRobotId() {
		return robotId;
	}

	/**
	 * @return the taskToDO
	 */
	public String getTaskToDo() {
		return taskToDo;
	}

	/**
	 * @return the robotType
	 */
	public RobotType getRobotType() {
		return robotType;
	}

	/**
	 * @return the taskType
	 */
	public TaskType getTaskType() {
		return taskType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task id=" + taskId + ", task = " + taskToDo + ", for robot type " + robotType
			+ ", "	+  taskType.getDescription() != null ? taskType.getDescription() : "type is empty";
	}

}
