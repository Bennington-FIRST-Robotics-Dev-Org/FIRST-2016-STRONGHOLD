package org.usfirst.frc.team5906.robot.commands;

import org.usfirst.frc.team5906.robot.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.CircleDescriptor;
import com.ni.vision.NIVision.CurveOptions;
import com.ni.vision.NIVision.ShapeDetectionOptions; 

import com.ni.vision.VisionException; 

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallLockOn extends Command {

    public BallLockOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.feed.DisableRawFeed(); 
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
        	NIVision.DetectCirclesResult res = NIVision.imaqDetectCircles(Robot.feed.img, new CircleDescriptor(1, 4), new CurveOptions(), new ShapeDetectionOptions(), NIVision.imaqCreateROI()); 
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

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.feed.EnableRawFeed(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end(); 
    }
}
