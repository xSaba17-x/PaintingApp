/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;



import javafx.scene.layout.Pane;

import javafx.scene.shape.Shape;

/**
 * This class allows us to create a command for the draw operation
 * @author pasqualecaggiano
 */
public class DrawCommand implements Command{
    private final Shape shape;
    private final Pane pane;
    
    /**
     * 
     * DrawCommand(Shape shape, Pane pane) is the class costructor
     * 
     * @param shape is the reference to the shape
     * @param pane is the reference to the drawing pane
     */

    public DrawCommand(Shape shape,Pane pane) {
        this.pane = pane;
        this.shape = shape;
    }

    /**
     * This method adds the shape to the drawing pane
     */
    @Override
    public void execute() {
        pane.getChildren().add(shape);
    }
    
    /**
     * This method removes the shape from the drawing pane
     */
    @Override
    public void undo() {
        pane.getChildren().remove(shape);
    }

  
}
