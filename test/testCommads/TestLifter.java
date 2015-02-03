/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCommads;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usfirst.frc.team2212.robot.Robot;
import static org.usfirst.frc.team2212.robot.Robot.lifter;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Down;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Move;

/**
 *
 * @author ThinkRedstone
 */
public class TestLifter {

    static Robot robot;

    public TestLifter() {
    }

    @BeforeClass
    public static void setUpClass() {
        robot = new Robot();
        robot.robotInit();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMove() {
        Move move = new Move();
        move.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, lifter.getElevator().get(), 0);
        lifter.getUp().set(true);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(0, lifter.getElevator().get(), 0);
        lifter.getUp().set(false);
        move.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, lifter.getElevator().get(), 0);
        lifter.getDown().set(true);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(0, lifter.getElevator().get(), 0);
        lifter.getDown().set(false);
    }
    @Test
    public void testDown(){
        Down down = new Down();
        down.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(-1, lifter.getElevator().get(), 0);
        lifter.getDown().set(true);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(0, lifter.getElevator().get(), 0);
    }
}
