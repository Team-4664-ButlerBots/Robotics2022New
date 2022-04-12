package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Victor;

public class Collector {
    private Victor collector = new Victor(3);
    private ControllerManager cManager;
    public Collector(ControllerManager conManager){
        cManager = conManager;
    }

    public void Collect(){
        collector.set(cManager.collectorInput());
    }
}
