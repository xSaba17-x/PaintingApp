/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.shape.Shape;
import projectapp.singletons.Clonator;

/**
 *  This class allows us to create a command for the copy operation
 * @author pasqualecaggiano
 */
public class CopyCommand implements Command{
    private Clonator clonator;
    private Shape shape;
    
    /**
     * 
     * DrawCommand(Shape shape, Pane pane) is the class costructor
     * 
     * @param shape is the reference to the shape
     * @param pane is the reference to the drawing pane
     */
    public CopyCommand(Clonator clonator, Shape shape) {
        this.clonator = clonator;
        this.shape = shape;
    }
    
    /**
     * This method encodes the shape to XML format and saves it in a bytearray in order to allow the cloning
     */
    @Override
    public void execute() {
        clonator.encodeToXml(shape);
    }
    
    /**
     * This method clears the content of the bytearray to undo the copy operation
     */
    @Override
    public void undo() {
        clonator.setByteCloned(null);
    }
    
}
