/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
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
 * @author pasqualecaggiano
 */
public class DrawCommandTest {
    private Command command;
    private Pane pane;
    private Line line;
    private Rectangle rectangle;
    private Ellipse ellipse;
    
    
    @Before
    public void setUp() {
        line = new Line(200,200,300,300);
        line.setStroke(Color.RED);
        ellipse = new Ellipse(200,200,300,300);
        ellipse.setStroke(Color.RED);
        ellipse.setStroke(Color.YELLOW);
        rectangle = new Rectangle(200,200,300,300);
        rectangle.setStroke(Color.RED);
        rectangle.setStroke(Color.YELLOW);
        pane = new Pane();
        
    }

    /**
     * Test of execute method, of class DrawCommand.
     */
    @Test
    public void testExecuteLine() {
       System.out.println("execute");
         
       command = new DrawCommand(line,pane);
       command.execute();
       assertEquals(1,pane.getChildren().size());
       assertEquals(pane.getChildren().get(0),line);
 
    }
    
     /**
     * Test of execute method, of class DrawCommand.
     */
    @Test
    public void testExecuteRectangle() {
       System.out.println("execute");
      
       command = new DrawCommand(rectangle,pane);
       command.execute();
       assertEquals(1,pane.getChildren().size());
       assertEquals(pane.getChildren().get(0),rectangle);
       
    }
    
     /**
     * Test of execute method, of class DrawCommand.
     */
    @Test
    public void testExecuteEllipse() {
       System.out.println("execute");

       command = new DrawCommand(ellipse,pane);
       command.execute();
       assertEquals(1,pane.getChildren().size());
       assertEquals(pane.getChildren().get(0),ellipse);

    }
    
     /**
     * Test of undo method, of class DrawCommand.
     */
    @Test
    public void testUndoLine() {
       
       command = new DrawCommand(line,pane);
       command.execute();
       command.undo();
       assertEquals(0,pane.getChildren().size());

    } 
    
    /**
     * Test of undo method, of class DrawCommand.
     */
    @Test
    public void testUndoRectangle() {
       
       command = new DrawCommand(rectangle,pane);
       command.execute();
       command.undo();
       assertEquals(0,pane.getChildren().size());

    } 
    
    /**
     * Test of undo method, of class DrawCommand.
     */
    @Test
    public void testUndoEllipse() {
       
       command = new DrawCommand(ellipse,pane);
       command.execute();
       command.undo();
       assertEquals(0,pane.getChildren().size());
       
    } 
}
