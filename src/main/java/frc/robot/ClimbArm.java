package frc.robot;



import edu.wpi.first.wpilibj.motorcontrol.Victor;

public class ClimbArm {
    private Victor extendArm = new Victor(5);
    private Victor rotateArm = new Victor(4);
    private ControllerManager cManager;

    
    public ClimbArm(ControllerManager conManager){
        cManager = conManager;
    }

    public void armSpeed(){
        extendArm.set(cManager.getExtendInput()*Constants.extendArmSpeed);
        rotateArm.set(cManager.getRotateInput()*Constants.rotateArmSpeed);
        //System.out.println(cManager.getExtendInput()*Constants.extendArmSpeed+", "
        //+cManager.getRotateInput()*Constants.rotateArmSpeed);
    }

}
