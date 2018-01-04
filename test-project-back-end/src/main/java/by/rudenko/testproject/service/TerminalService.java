package by.rudenko.testproject.service;

import by.rudenko.testproject.model.Task;

public interface TerminalService {
	
    /**
     * Service task from queue.
     * 
     * @param task - @see {@link by.rudenko.testproject.model.Task}
     */
	void acceptTask(Task task);
	
	/**
	 * Service task of {@link by.rudenko.testproject.model.TaskType}.
	 * 
	 * @param task - @see {@link by.rudenko.testproject.model.Task}
	 */
	void acceptTaskTypeDo(Task task);
    
	/**
	 * Service task of {@link by.rudenko.testproject.model.TaskType}.
	 * 
	 * @param task - @see {@link by.rudenko.testproject.model.Task}
	 */
    void acceptTaskForAllRobot(Task task);
    
    /**
     * Delete robot by id.
     * 
     * @param id of robot.
     */
    void deleteRobot(String id);
    
    /**
     * 
     * Checks the pool size when {@link by.rudenko.testproject.robotpool.RobotPool} was 
     * creating and creates robots if they were deleted.
     * 
     */
    void serviceRobotPool();

}
