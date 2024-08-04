/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.RotateCommand;
import projectapp.singletons.SelectedShape;

/**
 * This class RotateTool is used to rotate a selected Shape. For this
 * reason, RotateTool extends SelectionTool
 * 
 * @author Sabatino
 */
public class RotateTool extends SelectionTool{
    
    private double startY;
    private double initialRotate;
    private VBox vboxChangeSize;
    private ContextMenu menu;
    
    /**
     * RotateTool(Pane pane, SelectedShape selectedShape, CommandExecutor executor,
     * ContextMenu menu, VBox vboxChangeSize, Group gridContainer) is the class constructor
     * @param pane
     * @param selectedShape
     * @param executor
     * @param menu
     * @param vboxChangeSize
     * @param gridContainer 
     */
    public RotateTool(Pane pane, SelectedShape selectedShape, CommandExecutor executor,
            ContextMenu menu, VBox vboxChangeSize, Group gridContainer) {
        super(pane, selectedShape, executor, menu, vboxChangeSize, gridContainer);
        this.vboxChangeSize = vboxChangeSize;
        this.menu = menu;
    }
    
    
    /**
     * This method will configure the preparation of the rotation of a selected shape.
     * The shape will be highlighted.
     * 
     * @param event
     * @param strokeColor
     * @param fillColor 
     */
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){

        vboxChangeSize.visibleProperty().set(false);
        menu.getItems().forEach(item -> {
            item.setDisable(true);
        });

        initialRotate = getSelectedShape().getShape().getRotate();
        startY = event.getY();
        
    }
    
    //used for onMousePressed test
    public double getStartY() {
        return startY;
    }

    /**
     * This method will set the rotation of the selectedShape using the mouse
     * 
     * @param event 
     */
    @Override
    public void onMouseDragged(MouseEvent event){
        getSelectedShape().getShape().setRotate((event.getY()-startY+initialRotate));
    }
    
    /**
     * This method will execute the RotateCommand in order to perform the undo
     * operation over the rotation.
     * 
     * @param event 
     */
    @Override
    public void onMouseReleased(MouseEvent event){
        getExecutor().execute(new RotateCommand(getSelectedShape(), initialRotate,(event.getY()-startY+initialRotate)));
    }
    
}
