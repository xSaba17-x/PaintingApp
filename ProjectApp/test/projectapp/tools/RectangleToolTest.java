/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.command.CommandExecutor;

/**
 *
 * @author Sabatino
 */
public class RectangleToolTest {
    
    private Pane pane;
    private CommandExecutor executor;
    private Tool rectangleTool;
    private Rectangle rectangle;
    private MouseEvent pressEvent;
    
    
    public RectangleToolTest() {
    }
    
    
    @Before
    public void setUp() {
        JFXPanel panel = new JFXPanel();
        ContextMenu menu = new ContextMenu();
        pane = new Pane();
        executor = new CommandExecutor();
        rectangleTool = new RectangleTool(pane,executor,menu);
        rectangle = new Rectangle(10,10,30,30);
        pressEvent = new MouseEvent(MouseEvent.MOUSE_PRESSED, 10, 10, 10, 10,MouseButton.PRIMARY, 1,  
                                false, false,false,false,false,false,false,false,false,false,null);
    }

    /**
     * Test of getShape method, of class RectangleTool.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
       
        assertEquals(null,rectangleTool.getShape());
       
       Color strokeColor = Color.RED;
       Color fillColor = Color.BLUE;
       rectangleTool.onMousePressed(pressEvent, strokeColor, fillColor);
       
        assertEquals(rectangle.getClass(),rectangleTool.getShape().getClass());
    }

    /**
     * Test of onMousePressed method, of class RectangleTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        rectangleTool.onMousePressed(pressEvent, strokeColor, fillColor);
        
        assertEquals(1,pane.getChildren().size());
        
        assertEquals(rectangle.getX(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMinX()),1);
        assertEquals(rectangle.getY(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMinY()),1);
    }

    /**
     * Test of onMouseDragged method, of class RectangleTool.
     */
    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
       
        
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        rectangleTool.onMousePressed(pressEvent, strokeColor, fillColor);

        MouseEvent event2 = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 40, 40, 10, 10,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);

        rectangleTool.onMouseDragged(event2);
        assertEquals(rectangle.getX() + rectangle.getWidth(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(rectangle.getY() + rectangle.getHeight(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMaxY()),1);
    }

    /**
     * Test of onMouseReleased method, of class RectangleTool.
     */
    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        rectangleTool.onMousePressed(pressEvent, strokeColor, fillColor);
        
        MouseEvent event2 = new MouseEvent(MouseEvent.MOUSE_RELEASED, 40, 40, 10, 10,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        
        rectangleTool.onMouseReleased(event2);
        assertEquals(rectangle.getX() + rectangle.getWidth(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(rectangle.getY() + rectangle.getHeight(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMaxY()),1);  
    }


    
      
    
}
