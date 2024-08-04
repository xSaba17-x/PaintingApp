/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Point2D;
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
 * @author pasqualecaggiano
 */
public class PasteCommandTest {
    
    private Command command;
    private Pane pane;
    private Clonator clonator;
    private Point2D point;
    private ContextMenu menu;
    private JFXPanel panel;
    
    
    
    @Before
    public void setUp() {
        pane = new Pane();
        clonator = Clonator.getIstance();
        point = new Point2D(10,20);
        panel = new JFXPanel();
        menu = new ContextMenu();
        menu.getItems().addAll(new MenuItem(),new MenuItem(),new MenuItem(),new MenuItem());
    }

    /**
     * Test of execute method, of class PasteCommand.
     */
    @Test
    public void testExecuteLine() {
        System.out.println("execute");
        
        Line line = new Line(5,5,20,20);
        line.setStroke(Color.RED);
        pane.getChildren().add(line);
        
        /*
            COPY + PASTE
        */
        
        command = new CopyCommand(clonator, line);
        command.execute();
        
        command = new PasteCommand(clonator, pane, point);
        command.execute();
        
        assertEquals(2,pane.getChildren().size());
        
        Line line2 = (Line) pane.getChildren().get(1);
        
        assertEquals(line.getStartX(), line2.getStartX(), 0);
        assertEquals(line.getStartY(), line2.getStartY(), 0);
        assertEquals(line.getEndX(), line2.getEndX(), 0);
        assertEquals(line.getEndY(), line2.getEndY(), 0);
        assertEquals(line.getStroke(), line2.getStroke());
        
        /*
            CUT + PASTE
        */
        
        
        command = new CutCommand(clonator, line, pane, menu);
        command.execute();
        
        command = new PasteCommand(clonator, pane, point);
        command.execute();
        
        assertEquals(2,pane.getChildren().size());
        
        Line line3 = (Line) pane.getChildren().get(1);
        
        assertEquals(line.getStartX(), line3.getStartX(), 0);
        assertEquals(line.getStartY(), line3.getStartY(), 0);
        assertEquals(line.getEndX(), line3.getEndX(), 0);
        assertEquals(line.getEndY(), line3.getEndY(), 0);
        assertEquals(line.getStroke(), line3.getStroke());
    }
    
    /**
     * Test of execute method, of class PasteCommand.
     */
    @Test
    public void testExecuteRectangle() {
        System.out.println("execute");
        
        Rectangle rectangle = new Rectangle(5,5,20,20);
        rectangle.setStroke(Color.RED);
        pane.getChildren().add(rectangle);
        
        
        /*
            COPY + PASTE
        */
        command = new CopyCommand(clonator, rectangle);
        command.execute();
        
        command = new PasteCommand(clonator, pane, point);
        command.execute();
        
        assertEquals(2,pane.getChildren().size());
        
        Rectangle rectangle2 = (Rectangle) pane.getChildren().get(1);
        
        assertEquals(rectangle.getX(), rectangle2.getX(), 0);
        assertEquals(rectangle.getY(), rectangle2.getX(), 0);
        assertEquals(rectangle.getWidth(), rectangle2.getWidth(), 0);
        assertEquals(rectangle.getHeight(), rectangle2.getHeight(), 0);
        assertEquals(rectangle.getStroke(), rectangle2.getStroke());
        assertEquals(rectangle.getFill(), rectangle2.getFill());
        
        /*
            CUT + PASTE
        */
        
        command = new CutCommand(clonator, rectangle, pane, menu);
        command.execute();
        
        command = new PasteCommand(clonator, pane, point);
        command.execute();
        
        assertEquals(2,pane.getChildren().size());
        
        Rectangle rectangle3 = (Rectangle) pane.getChildren().get(1);
        
        assertEquals(rectangle.getX(), rectangle3.getX(), 0);
        assertEquals(rectangle.getY(), rectangle3.getX(), 0);
        assertEquals(rectangle.getWidth(), rectangle3.getWidth(), 0);
        assertEquals(rectangle.getHeight(), rectangle3.getHeight(), 0);
        assertEquals(rectangle.getStroke(), rectangle3.getStroke());
        assertEquals(rectangle.getFill(), rectangle3.getFill());
        
    }
    
    
    /**
     * Test of execute method, of class PasteCommand.
     */
    @Test
    public void testExecuteEllipse() {
        System.out.println("execute");
        
        Ellipse ellipse = new Ellipse(5,5,20,20);
        ellipse.setStroke(Color.RED);
        pane.getChildren().add(ellipse);
        
        /*
            COPY + PASTE
        */
        
        command = new CopyCommand(clonator, ellipse);
        command.execute();
        
        command = new PasteCommand(clonator, pane, point);
        command.execute();
        
        assertEquals(2,pane.getChildren().size());
        
        Ellipse ellipse2 = (Ellipse) pane.getChildren().get(1);
        
        assertEquals(ellipse.getCenterX(), ellipse2.getCenterX(), 0);
        assertEquals(ellipse.getCenterX(), ellipse2.getCenterY(), 0);
        assertEquals(ellipse.getRadiusX(), ellipse2.getRadiusX(), 0);
        assertEquals(ellipse.getRadiusY(), ellipse.getRadiusY(), 0);
        assertEquals(ellipse.getStroke(), ellipse2.getStroke());
        assertEquals(ellipse.getFill(), ellipse2.getFill());
        
        /*
            CUT + PASTE
        */
        
        
        command = new CutCommand(clonator, ellipse, pane, menu);
        command.execute();
        
        command = new PasteCommand(clonator, pane, point);
        command.execute();
        
        assertEquals(2,pane.getChildren().size());
        
        Ellipse ellipse3 = (Ellipse) pane.getChildren().get(1);
        
        assertEquals(ellipse.getCenterX(), ellipse3.getCenterX(), 0);
        assertEquals(ellipse.getCenterX(), ellipse3.getCenterY(), 0);
        assertEquals(ellipse.getRadiusX(), ellipse3.getRadiusX(), 0);
        assertEquals(ellipse.getRadiusY(), ellipse3.getRadiusY(), 0);
        assertEquals(ellipse.getStroke(), ellipse3.getStroke());
        assertEquals(ellipse.getFill(), ellipse3.getFill());
    }
    
 
    /**
     * Test of undo method, of class PasteCommand.
     */
    @Test
    public void testUndoLine() {
       System.out.println("undo");
       
       Line line = new Line(5,5,20,20);
       line.setStroke(Color.RED);
       
       command = new CopyCommand(clonator,line);
       command.execute();
       
       command = new PasteCommand(clonator,pane,point);
       command.execute();
       
       command.undo();
       
       assertEquals(0,pane.getChildren().size());
        
    }
    
    
    /**
     * Test of undo method, of class PasteCommand.
     */
    @Test
    public void testUndoRectangle() {
       System.out.println("undo");
       
       Rectangle rectangle = new Rectangle(5,5,20,20);
       rectangle.setStroke(Color.RED);
       
       command = new CopyCommand(clonator,rectangle);
       command.execute();
       
       command = new PasteCommand(clonator,pane,point);
       command.execute();
       
       command.undo();
       
       assertEquals(0,pane.getChildren().size());
        
    }
    
    
    /**
     * Test of undo method, of class PasteCommand.
     */
    @Test
    public void testUndoEllipse() {
       System.out.println("undo");
       
       Ellipse ellipse = new Ellipse(5,5,20,20);
       ellipse.setStroke(Color.RED);
       
       command = new CopyCommand(clonator,ellipse);
       command.execute();
       
       command = new PasteCommand(clonator,pane,point);
       command.execute();
       
       command.undo();
       
       assertEquals(0,pane.getChildren().size());
        
    }
    
}
