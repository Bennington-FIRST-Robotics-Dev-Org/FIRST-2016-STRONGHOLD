package org.usfirst.frc.team5906.robot.commands;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.CircleDescriptor;
import com.ni.vision.NIVision.CurveOptions;
import com.ni.vision.NIVision.ShapeDetectionOptions; 


import org.usfirst.frc.team5906.robot.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.VisionException;

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
    	Robot.feed.DisableRawFeed(); 
    }


    protected void execute() {
    	Robot.driveSys.ChangeSensitivity((Robot.oi.XboxController.getRawAxis(3) - Robot.oi.XboxController.getRawAxis(2)) * 0.02); 
    	Robot.driveSys.TankDrive(-Robot.oi.XboxController.getY(), -Robot.oi.XboxController.getRawAxis(5)); 
    	NIVision.DetectCirclesResult res = NIVision.imaqDetectCircles(Robot.feed.img, new CircleDescriptor(1, 4), new CurveOptions(), new ShapeDetectionOptions(), NIVision.imaqCreateROI()); 
    	try {
    	for (int i = 1; i < res.array.length; i++) { 
    		System.out.println("Radius: " + res.array[i].radius); 
    		System.out.println("Position: " + res.array[i].position); 
    		System.out.println("Score: " + res.array[i].score); 
    	} 
    	} 
    	catch (VisionException ex) { 
    		System.out.println(ex.toString());
    	} 
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() { 
    	Robot.driveSys.TankDrive(0, 0);  
    	Robot.feed.EnableRawFeed(); 
    }

    protected void interrupted() {
    	this.end(); 
    }
}
