/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCommads;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.usfirst.frc.team2212.robot.Robot;
import static org.usfirst.frc.team2212.robot.Robot.*;
import org.usfirst.frc.team2212.robot.commands.driving.*;

/**
 *
 * @author ThinkRedstone
 */
public class TestDriving {
    
    public TestDriving() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Robot robot = new Robot();
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
    public void testForward(){
        Forward f = new Forward();
        f.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestDriving.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(driveTrain);
        assertEquals(-1,driveTrain.getLeft().get(),0);
        assertEquals(1,driveTrain.getRight().get(),0);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
