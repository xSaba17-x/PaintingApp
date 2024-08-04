/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author acoon
 */
public class Grid {
    Group group;
    private static final double DELTA = 300;
    public Grid(){
        
        
    }
    
    public Group create(Pane drawingPane, Double size){
        group = new Group();
        for(double i = 0.0; i<drawingPane.getPrefWidth(); i +=  drawingPane.getPrefHeight()/(DELTA/size)){
            Line line = new Line(0, i,  drawingPane.getPrefHeight(), i);
            line.setStroke(Color.GREY);
            group.getChildren().add(line);
        }
        
        for(double i = 0.0; i< drawingPane.getPrefHeight(); i += drawingPane.getPrefWidth()/(DELTA/size)){
            Line line = new Line(i, 0, i,drawingPane.getPrefHeight());
            line.setStroke(Color.GREY);
            group.getChildren().add(line);
        }
        return group;
    }
}
