
package frc.robot;
 
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
 
public class DriveTrain {
    private Victor m_leftMC = new Victor(6);
    private Victor m_rightMC = new Victor(7);
    private DifferentialDrive m_drive = new DifferentialDrive(m_leftMC, m_rightMC);
    private ControllerManager cManager;
 
    public DriveTrain(ControllerManager cManager) {
        this.cManager = cManager;
        m_rightMC.setInverted(true);  
    }
 
    public void operatorDrive() {
        double[] input = cManager.getDriveInput();
        if (cManager.speedToggle())
            m_drive.tankDrive(-input[1] * Constants.driveSlowSpeed, -input[0] * Constants.driveSlowSpeed);
        else
            m_drive.tankDrive(-input[1]*Constants.driveFastSpeed, -input[0]*Constants.driveFastSpeed);
       
    }
 
    public void operatorJoystickDrive(){
        double[] input = cManager.getJoystickDriveInput();
        m_drive.arcadeDrive(-input[0], input[1]);
    }
 
    public DifferentialDrive getDiffDrive() {
        return m_drive;
    }
 
}


