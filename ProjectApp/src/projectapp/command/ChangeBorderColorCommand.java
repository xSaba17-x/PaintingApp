/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *This class represents the command that allows you to change the border color 
 * of a previously selected figure.
 * @author pancraziocirillo
 */
public class ChangeBorderColorCommand implements Command{
    private final Shape shape;
    private final Color oldStrokeColor;
    private final Color newStrokeColor;

    /**
     * 
     * ChangeBorderColorCommand(Shape shape, Color newStrokeColor) is the class costructor
     * 
     * @param shape is the reference to the shape
     * @param newStrokeColor is the new color of the shape
     */

    public ChangeBorderColorCommand(Shape shape, Color newStrokeColor) {
        this.shape = shape;
        this.oldStrokeColor = (Color) shape.getStroke();
        this.newStrokeColor = newStrokeColor;
    }
    
    /**
     * This method change the border color of the selected shape
     */
    @Override
    public void execute() {
        shape.setStroke(newStrokeColor);
    }
    
    /**
     * This method reset the previous border color of the selected shape
     */
    @Override
    public void undo() {
        shape.setStroke(oldStrokeColor);    
    }
}
