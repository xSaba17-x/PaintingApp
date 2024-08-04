/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;


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
public class ChangeInteriorColorCommandTest {
    private ChangeInteriorColorCommand command;
    

    @Before
    public void setUp() {
        
    }

    /**
     * Test of execute method, of class ChangeInteriorColorCommand.
     */
    @Test
    public void testExecuteLine() {
        System.out.println("execute");
        
        Line line=new Line(200,200,300,300);
        line.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(line,Color.BLUE);
        command.execute();
        assertEquals(line.getFill(),Color.BLUE);
        
    }
    
    /**
     * Test of execute method, of class ChangeInteriorColorCommand.
     */
    @Test
    public void testExecuteRectangle() {
        System.out.println("execute");
        Rectangle rectangle=new Rectangle(200,200,300,300);
        rectangle.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(rectangle,Color.BLUE);
        command.execute();
        assertEquals(rectangle.getFill(),Color.BLUE);
      
    }
    
    /**
     * Test of execute method, of class ChangeInteriorColorCommand.
     */
    @Test
    public void testExecuteEllipse() {
        System.out.println("execute");

        Ellipse ellipse=new Ellipse(200,200,300,300);
        ellipse.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(ellipse,Color.BLUE);
        command.execute();
        assertEquals(ellipse.getFill(),Color.BLUE);
    }
    
     /**
     * Test of undo method, of class ChangeInteriorColorCommand.
     */
    @Test
    public void testUndoLine() {
        System.out.println("execute");
        
        Line line=new Line(200,200,300,300);
        line.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(line,Color.BLUE);
        command.execute();
        command.undo();
        assertEquals(line.getFill(),Color.RED);
        
    }
    
     /**
     * Test of undo method, of class ChangeInteriorColorCommand.
     */
    @Test
    public void testUndoRectangle() {
        System.out.println("execute");
        
        Rectangle rectangle=new Rectangle(200,200,300,300);
        rectangle.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(rectangle,Color.BLUE);
        command.execute();
        command.undo();
        assertEquals(rectangle.getFill(),Color.RED);
        
    }
    
     /**
     * Test of undo method, of class ChangeInteriorColorCommand.
     */
    @Test
    public void testUndoEllipse() {
        System.out.println("execute");
        
        Ellipse ellipse=new Ellipse(200,200,300,300);
        ellipse.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(ellipse,Color.BLUE);
        command.execute();
        command.undo();
        assertEquals(ellipse.getFill(),Color.RED);
        
    }
    
    
}
