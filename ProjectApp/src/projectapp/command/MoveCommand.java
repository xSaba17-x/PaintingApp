/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;


import javafx.scene.shape.Shape;

/**
 * This class allows us to create a command for the move operation
 * @author acoon
 */

public class MoveCommand implements Command{
    private Shape shape;
    private final double newX;
    private final double newY;
    private final double oldX;
    private final double oldY;
    
    /**
     * 
     * MoveCommand(Shape shape, double newX, double newY, double oldX, double oldY) is 
     * the class costructor
     * 
     * @param shape is the reference to the shape
     * @param newX tells how much move the shape on the x-axis from the initial coordinate
     * @param newY tells how much move the shape on the y-axis from the initial coordinate
     * @param oldX is the old x-axis position of the shape
     * @param oldY is the old x-axis position of the shape
     */

    public MoveCommand(Shape shape, double newX, double newY, double oldX, double oldY) {
        this.shape = shape;
        this.newX = newX;
        this.newY = newY;
        this.oldX = oldX;
        this.oldY = oldY;
    }
    
    public Shape getShape() {
        return shape;
    }

    /**
     * This method translate the shape according to the new x and y coordinate 
     */
    @Override
    public void execute() {
        this.shape.setTranslateX(newX);
        this.shape.setTranslateY(newY);
        
    }

    /**
     * This method translate the shape in the oldest coordinates
     */
    @Override
    public void undo() {
        this.shape.setTranslateX(oldX);
        this.shape.setTranslateY(oldY);
    }

  
}
