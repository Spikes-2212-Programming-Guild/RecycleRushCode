/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 * @author ThinkRedstone
 */
public class Gearbox {

    private VictorSP forward, backwards;

    public Gearbox(VictorSP forward, VictorSP backwards) {
        this.forward = forward;
        this.backwards = backwards;
    }

    public Gearbox(int forwardPort,int backwardsPort) {
        this(new VictorSP(forwardPort),new VictorSP(backwardsPort));
    }
    
    public void set(double speed){
        forward.set(speed);
        backwards.set(speed);
    }
    

}
