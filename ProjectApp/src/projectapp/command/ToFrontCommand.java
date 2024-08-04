/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 *
 * @author acoon
 */
public class ToFrontCommand implements Command{
    
    private Shape shape;
    private Pane pane;
    private int oldIndex;
    
    /**
     * ToFrontCommand(Shape shape, Pane pane) is the class costructor
     * 
     * @param shape is the refrence to the selected shape
     * @param pane is the reference to the pane 
     */
    public ToFrontCommand(Shape shape, Pane pane){
        this.shape = shape;
        this.pane = pane;
    }
    
    
    /**
     * The method execute() save the old position of the shape in the pane and
     * sets the shape in the foreground. The oldest value is necessary for the undo operation 
     */
    @Override
    public void execute() {
        oldIndex =  pane.getChildren().indexOf(shape);
        shape.toFront();
        
    }

    /**
     * The method undo() remove the figure and add it in the oldest position.
     */
    @Override
    public void undo() {
        
        pane.getChildren().remove(shape);
        pane.getChildren().add(oldIndex, shape);
        
    }
    
}
