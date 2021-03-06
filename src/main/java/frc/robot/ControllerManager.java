
package frc.robot;
 
import edu.wpi.first.wpilibj.Joystick;
public class ControllerManager {
 
    private Joystick gamepad = new Joystick(0);
    private Joystick joystick = new Joystick(1);
    // public Joystick joystick = new Joystick(1);
 
    private boolean speedToggled = false;
 
    public boolean speedToggle() {
        if (gamepad.getRawButtonPressed(1)) { // Toggle drive speed between fast and slow if pressed
            if (speedToggled)
                speedToggled = false;
            else
                speedToggled = true;
 
        }
        return speedToggled;
    }
 
    public double[] getDriveInput() {
        double[] input = new double[2];
 
        // Set inputs
        input[0] = gamepad.getRawAxis(3);
        input[1] = gamepad.getRawAxis(1);
 
        return input;
    }
 
    public double getTargetingDriveInput(){
        return joystick.getRawAxis(0) / 2;
    }
 
    public double collectorInput() {
        if (joystick.getRawButton(10)) {
            return -Constants.collectorSpeed;
        } else if (joystick.getRawButton(11)) {
            return Constants.collectorSpeed;
        } else {
            return 0;
        }
    }
 
    /**
     * returns 1 for trigger held down, 0 for not pressed, and -1 for release period.
     * The release period is true for 1 second after release
     * @return
     */
    double time = 0;
    /*public int getShootState() {
        if (joystick.getTrigger()) {
            return 1;
        }else if(joystick.getTriggerReleased()){
            time = System.currentTimeMillis()/1000.0;
            return -1;
        }else{
            //returns the released state for a second after letting go.
            if(System.currentTimeMillis()/1000.0 - time < 0.7){
                return -1;
            }else{
                return 0;
            }
        }
    }*/
/*      Used for joystick arm controls, switching to triggers
    public double getExtendInput() {
        return joystick.getRawAxis(1); 

    }
    public double getRotateInput(){
        //return joystick.getRawAxis(0);
 
    
    }
*/  public double getExtendInput(){
        if(joystick.getRawButton(3)&&!joystick.getRawButton(2)){
           return 1.0; 
        }
        if(!joystick.getRawButton(3)&&joystick.getRawButton(2)){
            return -1.0;
        }
            return 0;
    }
    
    public double getRotateInput(){
        if(joystick.getRawButton(5)&&!joystick.getRawButton(4)){
           return 1.0; 
        }
        if(!joystick.getRawButton(5)&&joystick.getRawButton(4)){
            return -1.0;
        }
            return 0;
    }

    /*public boolean lookAtBall() {
        return gamepad.getRawButton(8);
    }
 
    public boolean followBall() {
        return gamepad.getRawButton(7);
    }*/
 
    /*public double getFlyWheelSpeed() {        Use for analog speeds for the flywheel on joystick knob
        return (joystick.getRawAxis(2) + 1.0)/2;
    }
    */
    public double getFlyWheelSpeed(){
        if((joystick.getRawButton(6)||joystick.getRawButton(7))&&!(joystick.getRawButton(6)&&joystick.getRawButton(7))){
                if(joystick.getRawButton(6)){
                    return (joystick.getRawAxis(2)+1)*Constants.flywheelFwdSpeed*20;
                }
                if(joystick.getRawButton(7)){
                    return -(joystick.getRawAxis(2)+1)*Constants.flywheelBkwdSpeed*20;
                }


        }
        return 0;
    }
    /*private boolean armed = false;
    public boolean getArmed(){
        if(joystick.getRawButtonPressed(3)){
            armed = !armed;
        }
        return armed || joystick.getTrigger();
    }*/
 
    public boolean ShootManualOverride(){
        return joystick.getRawButton(6);
    }
 
    /*public boolean TargetingMode(){
        return joystick.getRawButton(2);
    }*/
 
    public double[] getJoystickDriveInput() {
        double[] input = new double[2];
        double speedMult = 0.5;
        if(joystick.getTrigger()){
            speedMult = 1;
        }else{
            speedMult = 0.5;
        }
 
        input[0] = joystick.getRawAxis(1) * speedMult;
        input[1] = joystick.getRawAxis(0) * 0.75;
        return input;
    }
 
}

