/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class GridTest {
    private Pane pane;
    private Grid grid;
    Group gridGroup;
    private static final double DELTA = 300;
    
    @Before
    public void setUp() {
        pane = new Pane();
        pane.setPrefSize(100.0, 100.0);
        grid = new Grid();
        gridGroup = new Group();
    }

    @Test
    public void testCreate() {
        gridGroup = grid.create(pane, 1.0);
        assertNotEquals(gridGroup.getChildren().size(), 0);
        int j = 0;
        for (double i=0; i < pane.getPrefWidth(); i+= pane.getPrefHeight()/(DELTA/1.0)){
            Line line = (Line) gridGroup.getChildren().get(j);
            assertEquals(line.getStartX(), 0, 0.5);
            assertEquals(line.getStartY(), i, 0.5);
            assertEquals(line.getEndX(), pane.getPrefHeight(), 0.5);
            assertEquals(line.getEndY(), i, 0.5);
            j++;
        }
        
        for (double i=j; i < pane.getPrefHeight(); i+= pane.getPrefWidth()/(DELTA/1.0)){
            Line line = (Line) gridGroup.getChildren().get(j);
            assertEquals(line.getStartX(), 0, 0.5);
            assertEquals(line.getStartY(), i, 0.5);
            assertEquals(line.getEndX(), pane.getPrefHeight(), 0.5);
            assertEquals(line.getEndY(), i, 0.5);
            j++;
        }
   
    }
    
}
