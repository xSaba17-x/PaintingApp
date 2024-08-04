/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import projectapp.singletons.SelectedShape;

/**
 * This class allows us to create a command for the Change Size operation
 * 
 * @author Sabatino
 */
public class ChangeSizeCommand implements Command{
    
    private Shape shape;
    private double beforeX;
    private double beforeY;
    private double changeSizeX;
    private double changeSizeY;
    private VBox vboxChangeSize;
    
    
    /**
     * ChangeSizeCommand(SelectedShape selectedShape,double changeSizeX, double changeSizeY, Double beforeX,
     * Double beforeY, VBox vboxChangeSize) is the class constructor
     * 
     * @param selectedShape
     * @param changeSizeX
     * @param changeSizeY
     * @param beforeX
     * @param beforeY
     * @param vboxChangeSize 
     */
    public ChangeSizeCommand(SelectedShape selectedShape,double changeSizeX, double changeSizeY, VBox vboxChangeSize){
        this.shape = selectedShape.getShape();
        this.changeSizeX = changeSizeX;
        this.changeSizeY = changeSizeY;
        this.vboxChangeSize = vboxChangeSize;
    }
    
    /**
     * This method change the size of the selected shape
     */
    @Override
    public void execute() {
        beforeX = shape.getScaleX();
        beforeY = shape.getScaleY();
        if(changeSizeX+beforeX >= 0.1)
            shape.setScaleX(changeSizeX+beforeX);
        if(changeSizeY+beforeY >= 0.1)
            shape.setScaleY(changeSizeY+beforeY);
    }
    
    /**
     * This method restore the previous size of the selected shape
     */
    @Override
    public void undo() {
        shape.setScaleX(beforeX);
        shape.setScaleY(beforeY);
    }
    
}
