/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.tools.EllipseTool;
import projectapp.tools.LineTool;
import projectapp.tools.RectangleTool;

/**
 *
 * @author acoon
 */
public class MoveCommandTest {
    private Pane pane;
    private CommandExecutor executor;
    private EllipseTool ellipse;
    private RectangleTool rectangle;
    private LineTool line;
    private MoveCommand moveCommand;
    private MouseEvent pressEvent;
    private MouseEvent dragEvent;
    private ContextMenu menu;
    
    
    @Before
    public void setUp() {
        JFXPanel panel = new JFXPanel();
        pane = new Pane();
        executor = new CommandExecutor();
        pressEvent = new MouseEvent(MouseEvent.MOUSE_PRESSED, 0, 0, 0, 0, MouseButton.PRIMARY, 1,  
                                    false, false,false,false,false,false,false,false,false,false,null);
        dragEvent = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 10, 10, 0, 0, MouseButton.PRIMARY, 1,
                                    false, false,false,false,false,false,false,false,false,false,null);
        menu = new ContextMenu();
        ellipse = new EllipseTool(pane, executor, menu);
        rectangle = new RectangleTool(pane, executor, menu);
        line = new LineTool(pane, executor, menu);
    }

    @Test
    public void testExecuteEllipse() {
        System.out.println("executeEllipse");
        
        ellipse.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER);
        double oldValueX = ellipse.getShape().getTranslateX();
        double oldValueY = ellipse.getShape().getTranslateY();
        ellipse.onMouseDragged(dragEvent);
        moveCommand = new MoveCommand(ellipse.getShape(), 10,10,0,0);
        moveCommand.execute();
        assertNotEquals(oldValueX, ellipse.getShape().getTranslateX());
        assertNotEquals(oldValueY, ellipse.getShape().getTranslateY());
        assertEquals(10, ellipse.getShape().getTranslateX(), 0);
        assertEquals(10, ellipse.getShape().getTranslateY(), 0);
        
    }
    
    @Test
    public void testExecuteRectangle() {
        System.out.println("executeRectangle");
        
        rectangle.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER);
        double oldValueX = rectangle.getShape().getTranslateX();
        double oldValueY = rectangle.getShape().getTranslateY();
        rectangle.onMouseDragged(dragEvent);
        moveCommand = new MoveCommand(rectangle.getShape(),10,10,0,0);
        moveCommand.execute();
        assertNotEquals(oldValueX, rectangle.getShape().getTranslateX());
        assertNotEquals(oldValueY, rectangle.getShape().getTranslateY());
        assertEquals(10, rectangle.getShape().getTranslateX(), 0);
        assertEquals(10, rectangle.getShape().getTranslateY(), 0);      
    } 
    
    @Test
    public void testExecuteLine() {
        System.out.println("executeLine");
        
        line.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER);
        double oldValueX = line.getShape().getTranslateX();
        double oldValueY = line.getShape().getTranslateY();
        line.onMouseDragged(dragEvent);
        moveCommand = new MoveCommand(line.getShape(), 10,10,0,0);
        moveCommand.execute();
        assertNotEquals(oldValueX, line.getShape().getTranslateX());
        assertNotEquals(oldValueY, line.getShape().getTranslateY());
        assertEquals(10, line.getShape().getTranslateX(), 0);
        assertEquals(10, line.getShape().getTranslateY(), 0);
        
    }
    
    @Test
    public void testUndoEllipse(){
        System.out.println("undoEllipse");
        
        ellipse.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER);
        double oldValueX = ellipse.getShape().getTranslateX();
        double oldValueY = ellipse.getShape().getTranslateY();
        ellipse.onMouseDragged(dragEvent);
        moveCommand = new MoveCommand(ellipse.getShape(), 10,10,0,0);
        moveCommand.execute();
        moveCommand.undo();
        assertEquals(oldValueX, ellipse.getShape().getTranslateX(), 0);
        assertEquals(oldValueY, ellipse.getShape().getTranslateY(), 0);
    }
    
    @Test
    public void testUndoRectangle(){
        System.out.println("undoRectangle");
        
        rectangle.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER);
        double oldValueX = rectangle.getShape().getTranslateX();
        double oldValueY = rectangle.getShape().getTranslateY();
        rectangle.onMouseDragged(dragEvent);
        moveCommand = new MoveCommand(rectangle.getShape(), 10,10,0,0);
        moveCommand.execute();
        moveCommand.undo();
        assertEquals(oldValueX, rectangle.getShape().getTranslateX(), 0);
        assertEquals(oldValueY, rectangle.getShape().getTranslateY(), 0);
    }
    
    @Test
    public void testUndoLine(){
        System.out.println("undoLine");
        
        line.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER);
        double oldValueX = line.getShape().getTranslateX();
        double oldValueY = line.getShape().getTranslateY();
        line.onMouseDragged(dragEvent);
        moveCommand = new MoveCommand(line.getShape(), 10,10,0,0);
        moveCommand.execute();
        moveCommand.undo();
        assertEquals(oldValueX, line.getShape().getTranslateX(), 0);
        assertEquals(oldValueY, line.getShape().getTranslateY(), 0);
    }
}
