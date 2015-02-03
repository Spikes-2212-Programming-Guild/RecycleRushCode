/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCommads;

import edu.wpi.first.wpilibj.Relay;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.Robot.*;
import static org.usfirst.frc.team2212.robot.Robot.fork;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;

/**
 *
 * @author ThinkRedstone
 */
public class TestFork {

    static Robot robot;

    public TestFork() {
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
    public void testClose() {
        Close c = new Close();
        c.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(Relay.Value.kReverse, fork.getLock().get());
        fork.getClose().set(true);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(Relay.Value.kOff, fork.getLock().get());
    }
    @Test
    public void testOpen(){
        Open o = new Open();
        o.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(Relay.Value.kForward, fork.getLock().get());
        fork.getOpen().set(true);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFork.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(Relay.Value.kOff, fork.getLock().get());
    }
}
