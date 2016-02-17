package org.usfirst.frc.team5906.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid; 
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
	
	public Pneumatics() { 
		compres = new Compressor(Robot.map.CompressorID); 
		solenoid = new DoubleSolenoid(0, Robot.map.SolenoidForwardID, Robot.map.SolenoidReverseID); 
		pressure = new DigitalInput(Robot.map.PressureSensorPort);  
		this.compres.setClosedLoopControl(false); 
		this.compres.stop(); 
	} 
	
	public void StartCompressor() { 
		this.compres.setClosedLoopControl(true); 
	} 
	
	public void StopCompressor() { 
		this.compres.setClosedLoopControl(false); 
	} 
	
	public void SolenoidActivateForward() { 
		this.solenoid.set(DoubleSolenoid.Value.kReverse); 
	} 
	
	public void SolenoidActivateReverse() { 
		this.solenoid.set(DoubleSolenoid.Value.kForward);
	} 
	
	public void SolenoidActivateOff() { 
		this.solenoid.set(DoubleSolenoid.Value.kOff); 
	} 
	
	public boolean GetPressure() { 
		return this.compres.getPressureSwitchValue(); 
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

