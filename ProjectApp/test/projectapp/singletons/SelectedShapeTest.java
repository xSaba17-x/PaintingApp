/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.singletons;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasqualecaggiano
 */
public class SelectedShapeTest {
    private SelectedShape selectedShape;
    
    @Before
    public void setUp() {
        selectedShape = SelectedShape.getIstance();
    }

    /**
     * Test of getIstance method, of class SelectedShape.
     */
    @Test
    public void testGetIstance() {
        System.out.println("getIstance");
       
        assertEquals(SelectedShape.getIstance(),selectedShape);
    }

    
    /**
     * Test of setShape method, of class SelectedShape.
     */
    @Test
    public void testSetShape() {
        System.out.println("setShape");
        Shape shape = new Rectangle(30,30,30,30);
        
        selectedShape.setShape(shape);
        
        assertEquals(shape,selectedShape.getShape());
      
    }
    /**
     * Test of getShape method, of class SelectedShape.
     */
    @Test
    public void testGetShape() {
        // Alredy tested in set shape method
    }

  
    
}
