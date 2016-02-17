package org.usfirst.frc.team5906.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private int camsess; 
	
	public CameraSubsystem() { 
		try { 
			camsess = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			NIVision.IMAQdxConfigureGrab(this.camsess);
			NIVision.IMAQdxStartAcquisition(this.camsess);    
		} 
		catch (Exception ex) { 
			System.out.println("Camera init failed!");
		}
		
	}
	
	public Image GetCamImage(Image img) { 
		NIVision.IMAQdxGrab(this.camsess, img, 1);
		return img; 
	} 
	
	
    public void initDefaultCommand() {
        
    }
}

