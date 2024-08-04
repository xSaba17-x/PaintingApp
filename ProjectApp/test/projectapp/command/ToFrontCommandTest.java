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
 * @author acoon
 */
public class ToFrontCommandTest {
    
    private Pane pane;
    private ToFrontCommand toFrontCommand;
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
        toFrontCommand = new ToFrontCommand(ellipse, pane);
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        toFrontCommand.execute();
        assertEquals(pane.getChildren().indexOf(ellipse), pane.getChildren().size()-1);

        
    }

    @Test
    public void testUndo() {
        System.out.println("undo");
        int oldPosition = pane.getChildren().indexOf(ellipse);
        toFrontCommand.execute();
        assertEquals(pane.getChildren().indexOf(ellipse), pane.getChildren().size()-1);
        toFrontCommand.undo();
        assertEquals(oldPosition, pane.getChildren().indexOf(ellipse));


    }
    
}
