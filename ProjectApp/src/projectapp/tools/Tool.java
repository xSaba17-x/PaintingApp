/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;

/**
 * This abstract class shows all the operations that
 * must be performed differently for each state.
 * It is a part of the State Design Pattern
 * 
 * @author pasqualecaggiano
 */
public abstract class Tool {
    private Pane pane;
    private CommandExecutor executor;
    
    /**
     * The constructor takes in input the pane, where all the
     * shapes must be drown, and a CommandExecutor in order to
     * store and launch all the operations.
     * 
     * @param pane
     * @param executor
     */
    public Tool(Pane pane,CommandExecutor executor) {
        this.pane = pane;
        this.executor=executor;
    }

    public Pane getPane() {
        return pane;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }
    
    /**
     * This method will be implemented by each ShapeTool (not the SelectionTool)
     * in order to get the informations about the shape we are currently working on
     * 
     * @return Shape
     */
    public abstract Shape getShape();
    
    /**
     * This method will be implemented by the SelectionTool and it's duty is to
     * delete the selected shape from the pane
     * 
     */
    public abstract void deleteShape();
    
    /**
     * This method will be implemented by the SelectionTool and it's duty is to
     * change the border color of the selected shape on the pane
     * 
     * @param strokeColor 
     */
    public abstract void changeBorderColor(Color strokeColor);
    
    /**
     * This method will be implemented by the SelectionTool and it's duty is to
     * change the interior color of the selected shape on the pane
     * 
     * @param fillColor 
     */
    public abstract void changeInteriorColor(Color fillColor);
    
    /**
     * 
     * This method will be implemented by each class that extends Tool and it will
     * execute different operations based on the currentState. These operations will
     * be executed on the click of the mouse
     * 
     * @param event
     * @param strokeColor
     * @param fillColor 
     */
    public abstract void onMousePressed(MouseEvent event,Color strokeColor, Color fillColor);
    
    /**
     * This method will be implemented by each class that extends Tool and it will
     * execute different operations based on the currentState. These operations will
     * be executed on the drag of the mouse
     * 
     * @param event 
     */
    public abstract void onMouseDragged(MouseEvent event);
    
    /**
     * This method will be implemented by each class that extends Tool and it will
     * execute different operations based on the currentState. These operations will
     * be executed on the release of the mouse
     * 
     * @param event 
     */
    public abstract void onMouseReleased(MouseEvent event);
    
    
    public abstract void copy();
    public abstract void paste(Point2D point);
    public abstract void cut();
    public abstract void toFront();
    public abstract void toBack();
    public abstract void changeSize(double changeX,double changeY);
    public abstract void changeSizeBar();
    public abstract void mirror();
}

 
