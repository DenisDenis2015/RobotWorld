package by.rudenko.testproject.service;

import by.rudenko.testproject.model.Robot;
import by.rudenko.testproject.model.RobotType;

public interface RobotFactory {
	
	 public Robot createRobot(RobotType robotType);

}
