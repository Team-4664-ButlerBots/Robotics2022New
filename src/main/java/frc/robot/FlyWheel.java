package frc.robot;
 
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
//import edu.wpi.first.wpilibj.PIDBase.Tolerance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 
public class FlyWheel {
    private Victor shooterMC = new Victor(8);
    private Encoder Rencoder = new Encoder(2, 1);
    private Encoder Lencoder = new Encoder(4, 3);
    private double speed = 0;
    private ControllerManager cManager;
    private Collector collector;
 
    public FlyWheel(ControllerManager cManager, Collector collector){
        this.cManager = cManager;
        this.collector = collector;
    }
 
    public void operationalWheels(){
        //speedCheck();
        speed();
        //System.out.println(speed);
        shooterMC.set(speed);
    }
 
   
    public void speed(){                                    
        speed = cManager.getFlyWheelSpeed();
    }
}
