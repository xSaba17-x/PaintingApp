/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.shape.Shape;

/**
 * This class allow us to mirror the shape
 * @author acoon
 */
public class MirrorCommand implements Command {
    
    private Shape shape;
    private double oldScaleX;
    private double oldRotate;

    /**
     * 
     * @param shape is the reference to the shape that i want mirror
     */
    public MirrorCommand(Shape shape) {
        this.shape = shape;
        this.oldRotate = 1;
    }
    
    /**
     * This method allow us to mirror the shape, so it is necessary to moltiplicate
     * the current scale of the shape for -1. 
     * If the figure has previously been rotated then it is also necessary to multiply 
     * the rotation angle by -1. The oldScaleX and the oldRotate attirbute
     * are necessary for the undo operation.
     */
    @Override
    public void execute() {
        oldScaleX = shape.getScaleX();
        shape.setScaleX(-oldScaleX);
        if(shape.getRotate() != 0){
            shape.setRotate(-shape.getRotate());
            oldRotate = -1;
        }
    }
    
    /**
     * This method sets the old scale and the old rotate of the shape.
     */
    @Override
    public void undo() {
        shape.setScaleX(oldScaleX);
        shape.setRotate(shape.getRotate()*oldRotate);
    }
    
}
