package org.usfirst.frc.team5906.robot.commands;

import org.usfirst.frc.team5906.robot.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraFeed extends Command {

	
	Image img = null;
	private boolean LiveFeedMode; 
	
    public CameraFeed() {
        requires(Robot.camSys); 
        this.img = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	CameraServer.getInstance().setQuality(17);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
		Robot.camSys.GetCamImage(img); 
    	if (this.LiveFeedMode) { 
    		CameraServer.getInstance().setImage(img); 
    	} 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    } 
    
    public void DisableRawFeed() { 
    	this.LiveFeedMode = false; 
    } 
    
    public void EnableRawFeed() { 
    	this.LiveFeedMode = true; 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end(); 
    }
}