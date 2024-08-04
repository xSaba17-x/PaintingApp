/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

import javafx.scene.layout.Pane;
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
public class ToBackCommandTest {
    
    private Pane pane;
    private ToBackCommand toBackCommand;
    private Rectangle rectangle1;
    private Ellipse ellipse;
    private Line line;
    
    @Before
    public void setUp() {
        rectangle1 = new Rectangle(10,10,10,10);
        ellipse = new Ellipse(30,30,30,30);
        line = new Line(40,40,40,40);
        pane = new Pane();
        pane.getChildren().addAll(rectangle1, ellipse, line);
        toBackCommand = new ToBackCommand(ellipse, pane);
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        toBackCommand.execute();
        assertEquals(pane.getChildren().indexOf(ellipse), 0);
 
    }

    @Test
    public void testUndo() {
        System.out.println("undo");
        int oldPosition = pane.getChildren().indexOf(ellipse);
        toBackCommand.execute();
        assertEquals(pane.getChildren().indexOf(ellipse), 0);
        toBackCommand.undo();
        assertEquals(oldPosition, pane.getChildren().indexOf(ellipse));


    }
    }
    

