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
	
	private double sens = 1; 
	
	public DriveSubsystem(double sensitivity) { 
		this.DriveMotor1 = new Victor(Robot.map.DrivePort1); 
		this.DriveMotor2 = new Victor(Robot.map.DrivePort2); 
		this.DriveMotor3 = new Victor(Robot.map.DrivePort3); 
		this.DriveMotor4 = new Victor(Robot.map.DrivePort4); 
		this.driveobj = new RobotDrive(this.DriveMotor1, this.DriveMotor2, this.DriveMotor3, this.DriveMotor4);
		driveobj.setSensitivity(1);   
		driveobj.setSafetyEnabled(false);  
		this.ChangeSensitivity(sensitivity); 
	}
	
	public void TankDrive(double l, double r) { 
		this.driveobj.tankDrive(l*this.sens, r*this.sens);
	} 
	
	public void ChangeSensitivity(double c) { 
		this.sens = this.sens + c;   
		if (this.sens < 0) { 
			this.sens = 0; 
		}; 
		if (this.sens > 1) { 
			this.sens = 1; 
		}
	} 
	

    public void initDefaultCommand() {
    
	}
}
