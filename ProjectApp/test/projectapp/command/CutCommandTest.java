/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.singletons.Clonator;

/**
 *
 * @author Sabatino
 */
public class CutCommandTest {
    
    private Command command;
    private Pane pane;
    private Clonator clonator;
    
    private ContextMenu menu;
    
    private JFXPanel panel;
    
    @Before
    public void setUp() {
        panel = new JFXPanel();
        pane = new Pane();
        clonator = Clonator.getIstance();
        menu = new ContextMenu();        
        menu.getItems().add(new MenuItem("delete"));
        menu.getItems().add(new MenuItem("copy"));
        menu.getItems().add(new MenuItem("cut"));
        menu.getItems().add(new MenuItem("paste"));
        menu.getItems().add(new MenuItem("move"));


    }


    /**
     * Test of execute method, of class CutCommand.
     */
    @Test
    public void testExecuteLine() {
        System.out.println("execute Line");
        
        Line line = new Line(5,5,20,20);
        line.setStroke(Color.RED);
        pane.getChildren().add(line);
        int length = pane.getChildren().size();
        command = new CutCommand(clonator, line, pane, menu);
        command.execute();
        assertEquals(pane.getChildren().size(), length-1);
        assertFalse(pane.getChildren().contains(line));
        Line line2 = (Line) clonator.decodeFromXml();
        
        assertEquals(line.getStartX(), line2.getStartX(), 0);
        assertEquals(line.getStartY(), line2.getStartY(), 0);
        assertEquals(line.getEndX(), line2.getEndX(), 0);
        assertEquals(line.getEndY(), line2.getEndY(), 0);
        assertEquals(line.getStroke(), line2.getStroke());
        
    }
    
    /**
     * Test of execute method, of class CutCommand.
     */
    @Test
    public void testExecuteRectangle() {
        System.out.println("execute Rectangle");
        
        Rectangle rectangle = new Rectangle(5,5,20,20);
        rectangle.setStroke(Color.RED);
        pane.getChildren().add(rectangle);
        int length = pane.getChildren().size();
        command = new CutCommand(clonator, rectangle, pane, menu);
        command.execute();
        assertEquals(pane.getChildren().size(), length-1);
        assertFalse(pane.getChildren().contains(rectangle));
        Rectangle rectangle2 = (Rectangle) clonator.decodeFromXml();
        
        assertEquals(rectangle.getX(), rectangle2.getX(), 0);
        assertEquals(rectangle.getY(), rectangle2.getX(), 0);
        assertEquals(rectangle.getWidth(), rectangle2.getWidth(), 0);
        assertEquals(rectangle.getHeight(), rectangle2.getHeight(), 0);
        assertEquals(rectangle.getStroke(), rectangle2.getStroke());
        assertEquals(rectangle.getFill(), rectangle2.getFill());
        
    }
    
    /**
     * Test of execute method, of class CutCommand.
     */
    @Test
    public void testExecuteEllipse() {
        System.out.println("execute Ellipse");
        
        Ellipse ellipse = new Ellipse(5,5,20,20);
        ellipse.setStroke(Color.RED);
        pane.getChildren().add(ellipse);
        int length = pane.getChildren().size();
        command = new CutCommand(clonator, ellipse, pane, menu);
        command.execute();
        assertEquals(pane.getChildren().size(), length-1);
        assertFalse(pane.getChildren().contains(ellipse));
        Ellipse ellipse2 = (Ellipse) clonator.decodeFromXml();
        
        assertEquals(ellipse.getCenterX(), ellipse2.getCenterX(), 0);
        assertEquals(ellipse.getCenterX(), ellipse2.getCenterY(), 0);
        assertEquals(ellipse.getRadiusX(), ellipse2.getRadiusX(), 0);
        assertEquals(ellipse.getRadiusY(), ellipse2.getRadiusY(), 0);
        assertEquals(ellipse.getStroke(), ellipse2.getStroke());
        assertEquals(ellipse.getFill(), ellipse2.getFill());
        
    }

    /**
     * Test of undo method, of class CutCommand.
     */
    @Test
    public void testUndoLine() {
        System.out.println("undo Line");
        
        Line line = new Line(5,5,20,20);
        line.setStroke(Color.RED);
        pane.getChildren().add(line);
        int length = pane.getChildren().size();
        command = new CutCommand(clonator, line, pane, menu);
        command.execute();
        
        
        command.undo();
        Line line2  = (Line) pane.getChildren().get(0);
        assertEquals(pane.getChildren().size(), length);
        assertTrue(pane.getChildren().contains(line));
        
        assertEquals(line, line2);
    }
    
    /**
     * Test of undo method, of class CutCommand.
     */
    @Test
    public void testUndoRectangle() {
        System.out.println("undo Rectangle");
        
        Rectangle rectangle = new Rectangle(5,5,20,20);
        rectangle.setStroke(Color.RED);
        pane.getChildren().add(rectangle);
        int length = pane.getChildren().size();
        command = new CutCommand(clonator, rectangle, pane, menu);
        command.execute();
        
        
        command.undo();
        Rectangle rectangle2  = (Rectangle) pane.getChildren().get(0);
        assertEquals(pane.getChildren().size(), length);
        assertTrue(pane.getChildren().contains(rectangle));
        
        assertEquals(rectangle, rectangle2);
    }
    
    /**
     * Test of undo method, of class CutCommand.
     */
    @Test
    public void testUndoEllipse() {
        System.out.println("undo Ellipse");
        
        Ellipse ellipse = new Ellipse(5,5,20,20);
        ellipse.setStroke(Color.RED);
        pane.getChildren().add(ellipse);
        int length = pane.getChildren().size();
        command = new CutCommand(clonator, ellipse, pane, menu);
        command.execute();
        
        command.undo();
        Ellipse ellipse2  = (Ellipse) pane.getChildren().get(0);
        assertEquals(pane.getChildren().size(), length);
        assertTrue(pane.getChildren().contains(ellipse));
        
        assertEquals(ellipse, ellipse2);
        
    }
    
}
