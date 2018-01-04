package by.rudenko.testproject.service;

import java.util.Map;

import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.RobotType;
import by.rudenko.testproject.model.Task;

public interface RobotService {

    /**
     * Send work to specific robot by Id.
     * 
     * @param task - @see {@link by.rudenko.testproject.model.Task}.
     */
    void doWorkByRobotId(Task task);
    
    /**
     * Send work to any free robot of a particular type.
     * 
     * @param task - @see {@link by.rudenko.testproject.model.Task}.
     */
    void doWorkByRobotType(Task task);
    
    /**
     * Send work to any free robot.
     * 
     * @param task - @see {@link by.rudenko.testproject.model.Task}.
     */
    void doWorkAnyRobot(Task task);

    /**
     * Send the task to all robots.
     * 
     * @param task - @see {@link by.rudenko.testproject.model.Task}.
     */
    void doAllWork(Task task);

    /**
     * @return how many robots is free.
     */
    long checkHowManyRobotsIsFree();


    /**
     * @param type - @see {@link by.rudenko.testproject.model.RobotType}.
     * 
     * @return how many robots is free of a particular type.
     */
    long checkHowManyRobotsIsFreeByType(RobotType type);
    
    /**
     * 
     * @return robot count;
     */
    long getRobotCount();
    
    /**
     * Add robot to robotPool {@link by.rudenko.testproject.robotpool.RobotPool} of a particular type.
     * 
     * @param type - @see {@link by.rudenko.testproject.model.RobotType}.
     * 
     * @return robot  - @see {@link by.rudenko.testproject.model.Robot}.
     */
    Robot addRobot(RobotType type);
    
    /**
     * Delete robot by id.
     * 
     * @param id of robot;
     * 
     * @return true if delete successful and false if not.
     * 
     */
    boolean deleteRobot(String id);
    
    /**
     * Check if robot with id exist.
     * 
     * @param id of robot.
     * 
     * @return true if robot exist, and false if not.
     */
    boolean checkIfRobotExist(String id);
    
    /**
     * 
     * @return map of robot need to create.
     */
    Map<RobotType, Long> checkInitRobotPool();
    
}
