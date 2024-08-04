/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import static java.lang.Math.abs;
import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.DrawCommand;

/**
 * This class is a state in the pattern state and 
 * create an ellipse in a specific position with specific size indicated 
 * by the user with the mouse
 * 
 * @author acoon
 */
public class EllipseTool extends Tool{
    private Ellipse ellipse;
    
    /**
     * The costructor calls the costructor of Tool class
     * @param pane
     * @param executor 
     */
    public EllipseTool(Pane pane,CommandExecutor executor,ContextMenu menu) {
        super(pane,executor);
        this.ellipse = null;
        menu.getItems().forEach(item -> {
            item.setDisable(true);
        });
    }
   
    @Override
    public Shape getShape() {
        return ellipse;
    }
    
    /**
     * This method create an ellipse and sets all of its property and at the end
     * execute a draw command that recives the shape and add it to the pane
     * 
     * @param event is the mouse click event on the pane
     * @param strokeColor is the stroke color of the shape selected with colorPicker
     * @param fillColor  is the fill color of the shape selected with colorPicker
     */
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            ellipse = new Ellipse(); 
            ellipse.setCenterX(event.getX());
            ellipse.setCenterY(event.getY());
            ellipse.setRadiusX(0);
            ellipse.setRadiusY(0);
            ellipse.setStroke(strokeColor);
            ellipse.setFill(fillColor);
            getExecutor().execute(new DrawCommand(ellipse,getPane()));
        }
    }

    /**
     * This method update the property of the shape while the user do the drag 
     * operation on the pane with the mouse and allows us to show a preview of 
     * the shape on the pane
     * 
     * @param event is the mouse drag event on the pane
     */
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            ellipse.setRadiusX(abs(event.getX()-ellipse.getCenterX()));
            ellipse.setRadiusY(abs(event.getY()-ellipse.getCenterY()));
        }
    }

    /**
     * This method sets the last property of the shape when the user release the mouse
     * on the pane
     * 
     * @param event is the mouse release event on the pane
     */
    @Override
    public void onMouseReleased(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            ellipse.setRadiusX(abs(event.getX()-ellipse.getCenterX()));
            ellipse.setRadiusY(abs(event.getY()-ellipse.getCenterY()));
        }
    }
    
    /*
     *  Unimplemented methods of the abstract class Tool
     */
    @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}

    @Override
    public void deleteShape() {}

    @Override
    public void copy() {}

    @Override
    public void paste(Point2D point) {}

    @Override
    public void cut() {}

    @Override
    public void toFront() {}

    @Override
    public void toBack() {}

    @Override
    public void changeSize(double changeX,double changeY) {}

    @Override
    public void changeSizeBar() {}

    @Override
    public void mirror() {}
 
}
