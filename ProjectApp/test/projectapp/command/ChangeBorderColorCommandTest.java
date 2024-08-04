/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author 39320
 */
public class ChangeBorderColorCommandTest {
    private ChangeBorderColorCommand command;
    private Pane pane;
  
    
    @Before
    public void setUp() {
        Pane pane = new Pane();
        
    }
    
 
    /**
     * Test of execute method, of class ChangeBorderColorCommand.
     */
    @Test
    public void testExecuteLine() {
        System.out.println("execute");
        
        Line line=new Line(200,200,300,300);
        line.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(line,Color.BLUE);
        command.execute();
        assertEquals(line.getStroke(),Color.BLUE);
         
    }
    
    /**
     * Test of execute method, of class ChangeBorderColorCommand.
     */
    @Test
    public void testExecuteRectangle() {
        System.out.println("execute");
        Rectangle rectangle=new Rectangle(200,200,300,300);
        rectangle.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(rectangle,Color.BLUE);
        command.execute();
        assertEquals(rectangle.getStroke(),Color.BLUE); 
    }
    
    /**
     * Test of execute method, of class ChangeBorderColorCommand.
     */
    @Test
    public void testExecuteEllipse() {
        System.out.println("execute");
        
        Ellipse ellipse=new Ellipse(200,200,300,300);
        ellipse.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(ellipse,Color.BLUE);
        command.execute();
        assertEquals(ellipse.getStroke(),Color.BLUE);   
    }
    
    /**
     * Test of undo method, of class ChangeBorderColorCommand.
     */
    @Test
    public void testUndoLine() {
        System.out.println("undo");
        
        Rectangle rectangle=new Rectangle(200,200,300,300);
        rectangle.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(rectangle,Color.BLUE);
        command.execute();
        command.undo();
        assertEquals(rectangle.getStroke(),Color.RED);
         
    }
    
    /**
     * Test of undo method, of class ChangeBorderColorCommand.
     */
    @Test
    public void testUndoRectangle() {
        System.out.println("undo");
        
        Line line=new Line(200,200,300,300);
        line.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(line,Color.BLUE);
        command.execute();
        command.undo();
        assertEquals(line.getStroke(),Color.RED);
         
    }
    
    /**
     * Test of undo method, of class ChangeBorderColorCommand.
     */
    @Test
    public void testUndoEllipse() {
        System.out.println("undo");
        
        Ellipse ellipse=new Ellipse(200,200,300,300);
        ellipse.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(ellipse,Color.BLUE);
        command.execute();
        command.undo();
        assertEquals(ellipse.getStroke(),Color.RED);
         
    }
    
}
