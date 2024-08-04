/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * This class allows us to create a command for the delete operation
 * @author pasqualecaggiano
 */
public class DeleteCommand  implements Command{
    private final Shape shape;
    private final Pane pane;
    
    /**
     * 
     * DeleteCommand(Shape shape, Pane pane) is the class costructor
     * 
     * @param shape is the reference to the shape
     * @param pane is the reference to the drawing pane
     */
    public DeleteCommand(Shape shape,Pane pane) {
        this.pane = pane;
        this.shape = shape;
    }

    /**
     * This method removes the shape from the drawing pane
     */
    @Override
    public void execute() {
        pane.getChildren().remove(shape);
    }
    
    /**
     * This method adds the shape to the drawing pane
     */
    @Override
    public void undo() {
        pane.getChildren().add(shape);
    }

    
}
