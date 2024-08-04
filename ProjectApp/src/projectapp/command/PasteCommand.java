/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import projectapp.singletons.Clonator;

/**
 * This class allows us to create a command for the paste operation
 * @author pasqualecaggiano
 */
public class PasteCommand implements Command{
    private Clonator clonator;
    private Shape shape;
    private Pane pane;
    private Point2D point;
    private static final double TRASLATE_OFFSET = 200d;
    
    /**
     * 
     * PasteCommand(Shape shape, Pane pane) is the class costructor
     * 
     * @param shape is the reference to the shape
     * @param pane is the reference to the drawing pane
     */
    public PasteCommand(Clonator clonator, Pane pane, Point2D point) {
        this.clonator = clonator;
        this.shape = null;
        this.pane = pane;
        this.point = point;
    }
    
    /**
     * This method decodes the shape saved in the bytearray and adds it to the drawing pane in a position
     * related to the point where happened the context menu request.
     */
    @Override
    public void execute() {
        shape = clonator.decodeFromXml();
        shape.setTranslateX(point.getX()-TRASLATE_OFFSET);
        shape.setTranslateY(point.getY()-TRASLATE_OFFSET);
        pane.getChildren().add(shape);        
    }
    
    /**
     * This method remove the shape added to the drawing pane during the paste operation
     */
    @Override
    public void undo() {
        
        pane.getChildren().remove(shape);
        
    }  
}
