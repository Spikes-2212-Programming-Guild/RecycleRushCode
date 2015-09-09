/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThinkRedstone
 */
public class Macro implements Serializable {

    ArrayList<Pair<Long, List[]>> macroDriving;
    ArrayList<Pair<Long, List[]>> macroNavigating;
    private long lastWriteTime;

    /**
     *
     * @param buttonArray - 12 long array of booleans representing button states
     * @param axisArray - 3 long array of doubles, ranging from -1 to 1 in this
     * order: X axis, Y axis, Twist
     * @param buttonArrayNavig - same as buttonArray, only for nav joystick
     * @param axisArrayNavig - same as axisArray, only for nav joystick
     */
    public Macro(ArrayList buttonArray, ArrayList axisArray, ArrayList buttonArrayNavig, ArrayList axisArrayNavig) {
        macroDriving = new ArrayList<>();
        macroDriving.add(new Pair<>(0l, new List[]{buttonArray, axisArray}));
        lastWriteTime = System.currentTimeMillis();

        macroNavigating = new ArrayList<>();
        macroNavigating.add(new Pair<>(0l, new List[]{buttonArrayNavig, axisArrayNavig}));
        lastWriteTime = System.currentTimeMillis();
    }

    /**
     * @param buttonArray - 12 long array of booleans representing button states
     * @param axisArray - 3 long array of doubles, ranging from -1 to 1 in this
     * order: X axis, Y axis, Twist
     */
    public void addDataDriving(ArrayList buttonArray, ArrayList axisArray) {
        macroDriving.add(new Pair<Long, List[]>(System.currentTimeMillis()
                - lastWriteTime, new List[]{buttonArray, axisArray}));
        lastWriteTime = System.currentTimeMillis();
    }

    /**
     *
     * @param buttonArrayNav - 12 long array of booleans representing button
     * states for nav joystick
     * @param axisArrayNav - 3 long array of doubles, ranging from -1 to 1 in
     * this order: X axis, Y axis, Twist
     */
    public void addDataNavigating(ArrayList buttonArrayNav, ArrayList axisArrayNav) {
        macroNavigating.add(new Pair<Long, List[]>(System.currentTimeMillis()
                - lastWriteTime, new List[]{buttonArrayNav, axisArrayNav}));
        lastWriteTime = System.currentTimeMillis();
    }

    /**
     *
     * @return all the data gathered for the Driver joystick
     */
    public List<Pair<Long, List[]>> getDataDriving() {
        return (ArrayList) macroDriving.clone();
    }

    /**
     *
     * @return all the data gathered for the Nav joystick
     */
    public List<Pair<Long, List[]>> getDataNavigating() {
        return (ArrayList) macroNavigating.clone();
    }

}
