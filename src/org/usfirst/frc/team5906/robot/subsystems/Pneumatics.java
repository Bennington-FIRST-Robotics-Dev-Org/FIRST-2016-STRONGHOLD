package org.usfirst.frc.team5906.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team5906.robot.*;
/**
 *
 */
public class Pneumatics extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands. 
	
	private Compressor compres; 
	private DoubleSolenoid solenoid; 
	private DigitalInput pressure;
	private boolean SolenoidForward = false; 
	
	public Pneumatics() { 
		compres = new Compressor(Robot.map.CompressorID); 
		solenoid = new DoubleSolenoid(0, Robot.map.SolenoidForwardID, Robot.map.SolenoidReverseID); 
		pressure = new DigitalInput(Robot.map.PressureSensorPort);  
		this.compres.setClosedLoopControl(true); 
	} 
	
	public void StartCompressor() { 
		this.compres.setClosedLoopControl(true); 
	} 
	
	public void StopCompressor() { 
		this.compres.setClosedLoopControl(false); 
	} 
	
	public void SolenoidActivateForward() { 
		this.SolenoidForward = true; 
		this.solenoid.set(DoubleSolenoid.Value.kReverse); 
	} 
	
	public void SolenoidActivateReverse() { 
		this.SolenoidForward = false; 
		this.solenoid.set(DoubleSolenoid.Value.kForward);
	} 
	
	public void SolenoidActivateOff() { 
		this.solenoid.set(DoubleSolenoid.Value.kOff); 
	} 
	
	public boolean GetPressure() { 
		return this.compres.getPressureSwitchValue(); 
	} 
	
	public void SolenoidToggle() { 
		if (this.SolenoidForward) { 
			this.SolenoidActivateReverse(); 
			this.SolenoidForward = false;  
		} 
		else { 
			this.SolenoidActivateForward(); 
			this.SolenoidForward = true; 
		} 
		Timer.delay(0.05); 
		this.SolenoidActivateOff(); 
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

