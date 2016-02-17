package org.usfirst.frc.team5906.robot.subsystems;

import org.usfirst.frc.team5906.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
	private Victor DriveMotor1; 
	private Victor DriveMotor2;  
	private Victor DriveMotor3; 
	private Victor DriveMotor4; 
	
	private RobotDrive driveobj; 
	
	public DriveSubsystem(double sensitivity) { 
		this.DriveMotor1 = new Victor(Robot.map.DrivePort1); 
		this.DriveMotor2 = new Victor(Robot.map.DrivePort2); 
		this.DriveMotor3 = new Victor(Robot.map.DrivePort3); 
		this.DriveMotor4 = new Victor(Robot.map.DrivePort4); 
		this.driveobj = new RobotDrive(this.DriveMotor1, this.DriveMotor2, this.DriveMotor3, this.DriveMotor4);
		driveobj.setSensitivity(sensitivity);   
		driveobj.setSafetyEnabled(false);  
	}
	
	public void TankDrive(double l, double r) { 
		this.driveobj.tankDrive(l, r);
	}

    public void initDefaultCommand() {
    
	}
}
