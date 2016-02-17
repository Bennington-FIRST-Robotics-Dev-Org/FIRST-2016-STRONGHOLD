package org.usfirst.frc.team5906.robot.commands;

import org.usfirst.frc.team5906.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleOpDrive extends Command {

    public TeleOpDrive() {
    	requires(Robot.driveSys);
    }


    protected void initialize() {
    }


    protected void execute() {
    	Robot.driveSys.TankDrive(-Robot.oi.XboxController.getY(), -Robot.oi.XboxController.getRawAxis(5)); 
    	System.out.println(-Robot.oi.XboxController.getY());
    	System.out.println(-Robot.oi.XboxController.getRawAxis(5));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() { 
    	Robot.driveSys.TankDrive(0, 0); 
    }

    protected void interrupted() {
    	this.end(); 
    }
}
