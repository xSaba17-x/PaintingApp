/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.singletons.SelectedShape;

/**
 *
 * @author Sabatino
 */
public class RotateCommandTest {
    
    private Pane pane;
    private SelectedShape selectedShape;    
    
    public RotateCommandTest() {
    }

    
    @Before
    public void setUp() {
        pane = new Pane();
        selectedShape = SelectedShape.getIstance();
        
    }
    


    /**
     * Test of execute method, of class RotateCommand.
     */
    @Test
    public void testExecuteLine() {
        System.out.println("execute Line");
        
        Line line = new Line(10,10,20,20);
        selectedShape.setShape(line);
        RotateCommand command = new RotateCommand(selectedShape,0,2);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),2, 0);
        
        command = new RotateCommand(selectedShape,0,0);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
        command = new RotateCommand(selectedShape,0,-2);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),-2, 0);
    }
    
    /**
     * Test of execute method, of class RotateCommand.
     */
    @Test
    public void testExecuteRectangle() {
        System.out.println("execute Rectangle");
        
        Rectangle rectangle = new Rectangle(10,10,20,20);
        selectedShape.setShape(rectangle);
        RotateCommand command = new RotateCommand(selectedShape,0,2);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),2, 0);
        
        command = new RotateCommand(selectedShape,0,0);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
        command = new RotateCommand(selectedShape,0,-2);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),-2, 0);
    }

    
    /**
     * Test of execute method, of class RotateCommand.
     */
    @Test
    public void testExecuteEllipse() {
        System.out.println("execute Ellipse");
        
        Ellipse ellipse = new Ellipse(10,10,20,20);
        selectedShape.setShape(ellipse);
        RotateCommand command = new RotateCommand(selectedShape,0,2);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),2, 0);
        
        command = new RotateCommand(selectedShape,0,0);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
        command = new RotateCommand(selectedShape,0,-2);
        command.execute();
        assertEquals(selectedShape.getShape().getRotate(),-2, 0);
    }
    
    /**
     * Test of undo method, of class RotateCommand.
     */
    @Test
    public void testUndoLine() {
        System.out.println("undo Line ");
        
        Line line = new Line(10,10,20,20);
        selectedShape.setShape(line);
        RotateCommand command = new RotateCommand(selectedShape,0,2);
        command.execute();
        command.undo();
        assertEquals(selectedShape.getShape().getRotate(),0 ,0);
        
        
        command = new RotateCommand(selectedShape,0,-2);
        command.execute();
        command.undo();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
    }
    
    /**
     * Test of undo method, of class RotateCommand.
     */
    @Test
    public void testUndoRectangle() {
        System.out.println("undo Rectangle");
        
        Rectangle rectangle = new Rectangle(10,10,20,20);
        selectedShape.setShape(rectangle);
        RotateCommand command = new RotateCommand(selectedShape,0,2);
        command.execute();
        command.undo();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
        command = new RotateCommand(selectedShape,0,-2);
        command.execute();
        command.undo();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
    }
    
    /**
     * Test of undo method, of class RotateCommand.
     */
    @Test
    public void testUndoEllipse() {
        System.out.println("undo Ellipse");
        
        Ellipse ellipse = new Ellipse(10,10,20,20);
        selectedShape.setShape(ellipse);
        RotateCommand command = new RotateCommand(selectedShape,0,2);
        command.execute();
        command.undo();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
        command = new RotateCommand(selectedShape,0,-2);
        command.execute();
        command.undo();
        assertEquals(selectedShape.getShape().getRotate(),0, 0);
        
    }
    
}
