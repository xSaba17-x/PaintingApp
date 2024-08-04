/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.singletons;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasqualecaggiano
 */
public class ClonatorTest {
    private Clonator clonator;
    private Shape shape;
    
    @Before
    public void setUp() {
        clonator = Clonator.getIstance();
        shape = new Rectangle(100,100,30,30);
        
    }

    /**
     * Test of getIstance method, of class Clonator.
     */
    @Test
    public void testGetIstance() {
        System.out.println("getIstance");
        
        assertEquals(Clonator.getIstance(),clonator);
        
    }
    
     /**
     * Test of setByteCloned method, of class Clonator.
     */
    @Test
    public void testSetByteCloned() {
        System.out.println("setByteCloned");
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try(XMLEncoder encoder = new XMLEncoder(stream)){
            encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red","green","blue","opacity"}));
            encoder.writeObject(shape);
        }
        byte[] expected = stream.toByteArray();
        
        clonator.setByteCloned(expected);
        
        assertArrayEquals(expected,clonator.getByteCloned());  
    }
    
    /**
     * Test of getByteCloned method, of class Clonator.
     */
    @Test
    public void testGetByteCloned() {
      // Alredy tested in the testSetGetByteCloned
    }

   

  
    /**
     * Test of encodeToXml method, of class Clonator.
     */
    @Test
    public void testEncodeToXml() {
        System.out.println("encodeToXml");
        
        clonator.encodeToXml(shape);
        
        Shape newShape = clonator.decodeFromXml();
        System.out.println(shape.toString() + " " + newShape.toString());
        assertEquals(shape.toString(),newShape.toString());
       
    }

    /**
     * Test of decodeFromXml method, of class Clonator.
     */
    @Test
    public void testDecodeFromXml() {
        // Alredy tested in the testEncodeToXml
        
    }
    
}
