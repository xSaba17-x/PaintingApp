/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.embed.swing.JFXPanel;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.Grid;
import projectapp.command.CommandExecutor;
import projectapp.command.RotateCommand;
import projectapp.singletons.SelectedShape;

/**
 *
 * @author Sabatino
 */
public class RotateToolTest {
    
    private Pane pane;
    private VBox vboxChangeSize;
    private ContextMenu menu;
    private JFXPanel panel;
    private RotateTool tool;
    private SelectedShape selectedShape;
    private CommandExecutor executor;
    private Group gridContainer;
    private Shape shape;
    
    public RotateToolTest() {
    }
    

    
    @Before
    public void setUp() {
        panel = new JFXPanel();
        pane = new Pane();
        vboxChangeSize = new VBox();
        selectedShape = SelectedShape.getIstance();
        shape = new Line(10,10,20,20);
        selectedShape.setShape(shape);
        executor = new CommandExecutor();
        gridContainer = (new Grid()).create(pane, 1d);
        menu = new ContextMenu();
        tool = new RotateTool(pane,selectedShape,executor,menu,vboxChangeSize,gridContainer);
    }
    


    /**
     * Test of onMousePressed method, of class RotateTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        
        MouseEvent event = new MouseEvent(null, shape, new EventType("rotatePressed"), 100, 150, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, null);
        tool.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        assertEquals(tool.getStartY(), 150,0);
        assertFalse(vboxChangeSize.visibleProperty().get());
        menu.getItems().forEach(item -> {
            assertTrue(item.isDisable());
        });
    }

    /**
     * Test of onMouseDragged method, of class RotateTool.
     */
    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
        MouseEvent event = new MouseEvent(null, shape, new EventType("rotatePressed2"), 100, 150, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, null);
        MouseEvent event2 = new MouseEvent(null, shape, new EventType("rotatedragged"), 100, 140, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, null);
        double initialRotate = shape.getRotate();
        tool.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        tool.onMouseDragged(event2);
        assertEquals(selectedShape.getShape().getRotate(), -10,0);
        
        event2 = new MouseEvent(null, shape, new EventType("rotatedragged2"), 100, 160, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, null);
        tool.onMouseDragged(event2);
        assertEquals(selectedShape.getShape().getRotate(), 10, 1);
        
    }

    /**
     * Test of onMouseReleased method, of class RotateTool.
     */
    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        
        MouseEvent event = new MouseEvent(null, shape, new EventType("rotatePressed3"), 100, 150, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, null);
        MouseEvent event2 = new MouseEvent(null, shape, new EventType("rotatedragged3"), 100, 140, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, null);
        double initialRotate = shape.getRotate();
        tool.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        tool.onMouseDragged(event2);
        tool.onMouseReleased(event2);
        assertEquals(executor.getStack().removeLast().getClass(), RotateCommand.class);     
    }
    
}
