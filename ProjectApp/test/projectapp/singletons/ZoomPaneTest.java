/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.singletons;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasqualecaggiano
 */
public class ZoomPaneTest {
    private ZoomPane zoomPane;
   
    @Before
    public void setUp() {
        zoomPane = new ZoomPane();
        
    }

    /**
     * Test of getIstance method, of class ZoomPane.
     */
    @Test
    public void testGetIstance() {
        System.out.println("getIstance");
        ZoomPane z1 = ZoomPane.getIstance();
        ZoomPane z2 = ZoomPane.getIstance();
        assertEquals(z1,z2);
    }

    /**
     * Test of getScale method, of class ZoomPane.
     */
    @Test
    public void testGetScale() {
        System.out.println("getScale");
        assertEquals(1.0,zoomPane.getScale(),0);
        double scale = 10;
        zoomPane.setScale(scale);
        assertEquals(scale,zoomPane.getScale(),0);
    }

    /**
     * Test of setScale method, of class ZoomPane.
     */
    @Test
    public void testSetScale() {
        System.out.println("setScale");
         //Alredy tested in testGetScale
    }  
    
    /**
     * Test of zoom method, of class ZoomPane.
     */
    @Test
    public void testZoom() {
        System.out.println("zoom");
        
        boolean type = true;
        double expectedScale = zoomPane.getScale() * ZoomPane.DEFAULT_DELTA;
        zoomPane.zoom(type);
        assertEquals(expectedScale, zoomPane.getScale(),0);
        
        type = false;
        expectedScale = zoomPane.getScale() / ZoomPane.DEFAULT_DELTA;
        zoomPane.zoom(type);
        assertEquals(expectedScale, zoomPane.getScale(),0);
        
    }
}
