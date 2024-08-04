/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

/**
 *
 * @author 39320
 */
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 *
 * @author acoon
 */
public class ToBackCommand implements Command{
    
    private Shape shape;
    private Pane pane;
    private int oldIndex;
    
    /**
     * ToBackCommand(Shape shape, Pane pane) is the class costructor
     * 
     * @param shape is the refrence to the selected shape
     * @param pane is the reference to the pane 
     */
    public ToBackCommand(Shape shape, Pane pane){
        this.shape = shape;
        this.pane = pane;
    }
    
    
    /**
     * The method execute() save the old position of the shape in the pane and
     * sets the shape in the background. The oldest value is necessary for the undo operation 
     */
    @Override
    public void execute() {
        oldIndex =  pane.getChildren().indexOf(shape);
        shape.toBack();
        
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