package org.usfirst.frc.team5906.robot;

public class RobotStatus {
	private RobotStatusMode statmode = RobotStatusMode.UNDEFINED; 
	public RobotStatusMode GetStatusMode() { 
		return statmode; 
	}
	public void SetStatusMode(RobotStatusMode mode) { 
		statmode = mode; 
	}
}
