package org.usfirst.frc.team5906.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5906.robot.RobotStatus;
import org.usfirst.frc.team5906.robot.commands.AutonomousDrive;
import org.usfirst.frc.team5906.robot.commands.CameraFeed;
import org.usfirst.frc.team5906.robot.commands.TeleOpDrive;
import org.usfirst.frc.team5906.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team5906.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5906.robot.subsystems.Pneumatics;


public class Robot extends IterativeRobot {
	
	public static RobotStatus status; 
	public static RobotMap map; 
	public static OI oi; 
	public static DriveSubsystem driveSys;
	public static CameraSubsystem camSys; 
	public static Pneumatics pneu; 
	
	private TeleOpDrive teleOpDriveCommand;    
	private CameraFeed feed;     
	private AutonomousDrive autonomousDriveCommand; 
	
	
	private void CameraInit() { 
		feed = new CameraFeed(); 
    	feed.start(); 
	}
	
	private void SubsystemInit() { 
		this.driveSys = new DriveSubsystem(0.02); 
		this.camSys = new CameraSubsystem(); 
		this.pneu = new Pneumatics(); 
	}
	
	private void StatusInit() { 
		this.status = new RobotStatus(); 
	}
	
	private void TeleOpInit() { 
		this.teleOpDriveCommand = new TeleOpDrive(); 
	} 
	
	private void AutonomousInit() { 
		this.autonomousDriveCommand = new AutonomousDrive(); 
	} 
	
	private void InterfaceInit() { 
		map = new RobotMap(); 
		oi = new OI(); 
	} 
	
    public void robotInit() {
    	try { 
    		System.out.println("Subsystems being initialized.");    
    		this.SubsystemInit(); 
    		System.out.println("Subsystems initialized.");    
    		System.out.println("Camera being initialized.");    
    		this.CameraInit(); 
    		System.out.println("Camera initialized.");    
    		System.out.println("Status Class being initialized.");    
    		this.StatusInit(); 
    		System.out.println("Status Class initialized.");    
    		this.InterfaceInit(); 
    		System.out.println("Interfaces being initialized.");    
    		System.out.println("TeleOp being initialized.");    
    		this.TeleOpInit();  
    		System.out.println("TeleOp initialized.");    
    		System.out.println("Autonomous being initialized."); 
    		this.AutonomousInit(); 
    		System.out.println("Autonomous initialized."); 
    		Scheduler.getInstance().enable(); /* I think it works even without this line, but I'm playing it safe. */ 
    	} 
    	catch (Exception ex) { 
    		System.out.println(ex.getCause());
    	} 
    }
    
    public void SwitchMode() { 
    	Scheduler.getInstance().disable();
    	teleOpDriveCommand.cancel(); 
    	autonomousDriveCommand.cancel(); 
    	if (this.status.GetStatusMode() == RobotStatusMode.TELE) { 
    		teleOpDriveCommand.start(); 
    	}
    	else { 
    		autonomousDriveCommand.start(); 
    	}
    	Scheduler.getInstance().enable();
    }

    public void autonomousInit() {
    	this.status.SetStatusMode(RobotStatusMode.AUTO);
    	this.SwitchMode(); 
    }

    public void autonomousPeriodic() {
    	Scheduler.getInstance().run(); 
    }
    

    public void teleopInit(){
    	this.status.SetStatusMode(RobotStatusMode.TELE);
    	this.SwitchMode();
    }


    public void teleopPeriodic() {
    	Scheduler.getInstance().run(); 
    }
    

    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
