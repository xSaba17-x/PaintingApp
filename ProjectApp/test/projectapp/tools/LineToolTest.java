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
import javafx.scene.shape.Line;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.command.CommandExecutor;

/**
 *
 * @author pasqualecaggiano
 */
public class LineToolTest {
    private Tool lineTool;
    private Pane pane;
    private CommandExecutor executor;
    private Line line ;
    private MouseEvent press;
    private MouseEvent drag;
    private MouseEvent release;
    
    
    @Before
    public void setUp() {
        JFXPanel panel = new JFXPanel();
        ContextMenu menu = new ContextMenu();
        pane = new Pane();
        executor = new CommandExecutor();
        lineTool = new LineTool(pane,executor, menu);
        line = new Line(20,20,50,50);
        press = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        drag =  new MouseEvent(MouseEvent.MOUSE_DRAGGED, 30, 30, 30, 30,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        release = new MouseEvent(MouseEvent.MOUSE_RELEASED, 30, 30, 30, 30,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);

    }

   
    /**
     * Test of onMousePressed method, of class LineTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        lineTool.onMousePressed(press, strokeColor, fillColor);
        
        assertEquals(1,pane.getChildren().size());
        
        assertEquals(line.getStartX(),Math.rint(lineTool.getShape().getLayoutBounds().getMinX()),1);
        assertEquals(line.getStartY(),Math.rint(lineTool.getShape().getLayoutBounds().getMinY()),1);
        
    }
    
    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        lineTool.onMousePressed(press, strokeColor, fillColor);
        
        
        lineTool.onMouseDragged(drag);
        assertEquals(line.getEndX(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(line.getEndY(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxY()),1);
    }
    
    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        lineTool.onMousePressed(press, strokeColor, fillColor);
        
        
        lineTool.onMouseReleased(release);
        assertEquals(line.getEndX(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(line.getEndY(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxY()),1);   
    }

    /**
     * Test of getShape method, of class LineTool.
     */
    @Test
    public void testGetShape() {
       System.out.println("getShape");
       
       assertEquals(null,lineTool.getShape());
       
       Color strokeColor = Color.RED;
       Color fillColor = Color.BLUE;
       lineTool.onMousePressed(press, strokeColor, fillColor);
       
       assertEquals(line.getClass(),lineTool.getShape().getClass());
       
    }

}
