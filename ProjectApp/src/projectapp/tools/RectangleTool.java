/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.DrawCommand;

/**
 * This class is a state in the pattern state and 
 * create a rectangle in a specific position with specific size indicated 
 * by the user with the mouse
 * 
 * @author Sabatino
 */
public class RectangleTool extends Tool{
    private Rectangle rectangle;
    private double initialPositionX;
    private double initialPositionY;
    
    
    /**
     * The costructor calls the costructor of Tool class
     * @param pane
     * @param executor 
     */
    public RectangleTool(Pane pane,CommandExecutor executor, ContextMenu menu) {
        super(pane,executor);
        menu.getItems().forEach(item -> {
            item.setDisable(true);
        });
    }
    
    @Override
    public Shape getShape() {
        return rectangle;
    }
    
    
    /**
     * This method creates a rectangle and sets all of its property and at the end
     * execute a draw command that recives the line and add it to the pane
     * 
     * @param event is the mouse click event on the pane
     * @param strokeColor is the stroke color of the shape selected with colorPicker
     * @param fillColor  is the fill color of the shape selected with colorPicker
     */
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            rectangle = new Rectangle();
            rectangle.setStroke(strokeColor);
            rectangle.setFill(fillColor);
            rectangle.setX(event.getX());
            rectangle.setY(event.getY());
            rectangle.setWidth(0);
            rectangle.setWidth(0);
            this.initialPositionX = event.getX();
            this.initialPositionY = event.getY();
            getExecutor().execute(new DrawCommand(rectangle,getPane()));
        }
    }
    
    
    /**
     * This method updates the property of the rectangle while the user is doing the drag 
     * operation on the pane with the mouse and allows us to show a preview of 
     * the shape on the pane
     * 
     * @param event is the mouse drag event on the pane
     */
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            double startX = rectangle.getX();
            double startY = rectangle.getY();
            double endX = event.getX() - initialPositionX;
            double endY = event.getY() - initialPositionY;

            if(endX < 0 ){
                endX = -endX;
                rectangle.setX(event.getX());
            }
            if(endY < 0){
                endY = -endY;
                rectangle.setY(event.getY());
            }    
            rectangle.setWidth(endX);
            rectangle.setHeight(endY);
        }
    }
    
    /**
     * This method sets the last property of the rectangle when the user release the mouse
     * on the pane
     * 
     * @param event is the mouse release event on the pane
     */
    @Override
    public void onMouseReleased(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            double startX = rectangle.getX();
            double startY = rectangle.getY();
            double endX = event.getX() - initialPositionX;
            double endY = event.getY() - initialPositionY;
            if(endX < 0 ){
                endX = -endX;
                rectangle.setX(event.getX());
            }
            if(endY < 0){
                endY = -endY;
                rectangle.setY(event.getY());
            }

            rectangle.setWidth(endX);
            rectangle.setHeight(endY);
        }
    }

    /*
     *  Unimplemented methods of the abstract class tool
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
    public void paste(Point2D point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
