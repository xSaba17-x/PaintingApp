/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.singletons.SelectedShape;

/**
 *
 * @author Sabatino
 */
public class ChangeSizeCommandTest {
    
    private ChangeSizeCommand command;
    private SelectedShape selectedShape;
    private VBox vboxChangeSize;
    private Pane pane;
    
    
    public ChangeSizeCommandTest() {
    }

    @Before
    public void setUp() {
        selectedShape = SelectedShape.getIstance();
        vboxChangeSize = new VBox();
        pane = new Pane();
    }
    

    /**
     * Test of execute method, of class ChangeSizeCommand.
     */
    @Test
    public void testExecuteLine() {
        System.out.println("execute Line");
        
        Line line = new Line(10,10,30,30);
        pane.getChildren().add(line);
        selectedShape.setShape(line);
        command = new ChangeSizeCommand(selectedShape,0.1,0.1,vboxChangeSize);
        command.execute();
        assertEquals(line.getScaleX(), 1.1, 0);
        assertEquals(line.getScaleY(), 1.1, 0);
        
        command = new ChangeSizeCommand(selectedShape,-0.1,-0.1,vboxChangeSize);
        command.execute();
        assertEquals(line.getScaleX(), 1.0, 0);
        assertEquals(line.getScaleY(), 1.0, 0);

    }
    
    /**
     * Test of execute method, of class ChangeSizeCommand.
     */
    @Test
    public void testExecuteRectangle() {
        System.out.println("execute Rectangle");
        
        Rectangle rectangle = new Rectangle(10,10,30,30);
        pane.getChildren().add(rectangle);
        selectedShape.setShape(rectangle);
        command = new ChangeSizeCommand(selectedShape,0.1,0.1,vboxChangeSize);
        command.execute();
        assertEquals(rectangle.getScaleX(), 1.1, 0);
        assertEquals(rectangle.getScaleY(), 1.1, 0);
        
        command = new ChangeSizeCommand(selectedShape,-0.1,-0.1,vboxChangeSize);
        command.execute();
        assertEquals(rectangle.getScaleX(), 1.0, 0);
        assertEquals(rectangle.getScaleY(), 1.0, 0);

    }
    
    /**
     * Test of execute method, of class ChangeSizeCommand.
     */
    @Test
    public void testExecuteEllipse() {
        System.out.println("execute Ellipse");
        
        Ellipse ellipse = new Ellipse(10,10,30,30);
        pane.getChildren().add(ellipse);
        selectedShape.setShape(ellipse);
        command = new ChangeSizeCommand(selectedShape,0.1,0.1,vboxChangeSize);
        command.execute();
        assertEquals(ellipse.getScaleX(), 1.1, 0);
        assertEquals(ellipse.getScaleY(), 1.1, 0);
        
        command = new ChangeSizeCommand(selectedShape,-0.1,-0.1,vboxChangeSize);
        command.execute();
        assertEquals(ellipse.getScaleX(), 1.0, 0);
        assertEquals(ellipse.getScaleY(), 1.0, 0);

    }

    /**
     * Test of undo method, of class ChangeSizeCommand.
     */
    @Test
    public void testUndoLine() {
        System.out.println("undo Line");
        
        Line line = new Line(10,10,30,30);
        pane.getChildren().add(line);
        selectedShape.setShape(line);
        command = new ChangeSizeCommand(selectedShape,0.1,0.1,vboxChangeSize);
        command.execute();
        double x = line.getScaleX();
        double y = line.getScaleY();
        command.undo();
        assertEquals(line.getScaleX(),x-0.1, 0);
        assertEquals(line.getScaleY(),y-0.1, 0);
        
        command = new ChangeSizeCommand(selectedShape,-0.1,-0.1,vboxChangeSize);
        command.execute();
        x = line.getScaleX();
        y = line.getScaleY();
        command.undo();
        assertEquals(line.getScaleX(),x+0.1, 0);
        assertEquals(line.getScaleY(),y+0.1, 0);
    }
    
    /**
     * Test of undo method, of class ChangeSizeCommand.
     */
    @Test
    public void testUndoRectangle() {
        System.out.println("undo Rectangle");
        
        Rectangle rectangle = new Rectangle(10,10,30,30);
        pane.getChildren().add(rectangle);
        selectedShape.setShape(rectangle);
        command = new ChangeSizeCommand(selectedShape,0.1,0.1,vboxChangeSize);
        command.execute();
        double x = rectangle.getScaleX();
        double y = rectangle.getScaleY();
        command.undo();
        assertEquals(rectangle.getScaleX(),x-0.1, 0);
        assertEquals(rectangle.getScaleY(),y-0.1, 0);
        
        command = new ChangeSizeCommand(selectedShape,-0.1,-0.1,vboxChangeSize);
        command.execute();
        x = rectangle.getScaleX();
        y = rectangle.getScaleY();
        command.undo();
        assertEquals(rectangle.getScaleX(),x+0.1, 0);
        assertEquals(rectangle.getScaleY(),y+0.1, 0);
    }
    
    /**
     * Test of undo method, of class ChangeSizeCommand.
     */
    @Test
    public void testUndoEllipse() {
        System.out.println("undo Ellipse");
        
        Ellipse ellipse = new Ellipse(10,10,30,30);
        pane.getChildren().add(ellipse);
        selectedShape.setShape(ellipse);
        command = new ChangeSizeCommand(selectedShape,0.1,0.1,vboxChangeSize);
        command.execute();
        double x = ellipse.getScaleX();
        double y = ellipse.getScaleY();
        command.undo();
        assertEquals(ellipse.getScaleX(),x-0.1, 0);
        assertEquals(ellipse.getScaleY(),y-0.1, 0);
        
        command = new ChangeSizeCommand(selectedShape,-0.1,-0.1,vboxChangeSize);
        command.execute();
        x = ellipse.getScaleX();
        y = ellipse.getScaleY();
        command.undo();
        assertEquals(ellipse.getScaleX(),x+0.1, 0);
        assertEquals(ellipse.getScaleY(),y+0.1, 0);
    }
    
}
