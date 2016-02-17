package org.usfirst.frc.team5906.robot;

import org.usfirst.frc.team5906.robot.commands.PneumaticToggle;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class OI {
	public Joystick XboxController = new Joystick(0); 
	public SmartDashboard dash = new SmartDashboard(); 
	private JoystickButton MovePiston;
	
	public OI() { 
		this.MovePiston = new JoystickButton(this.XboxController, 6); 
		this.MovePiston.whenPressed(new PneumaticToggle());
	
	}
}

