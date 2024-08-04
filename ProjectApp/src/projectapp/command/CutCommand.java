/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import projectapp.singletons.Clonator;

/**
 * This class allows us to create a command for the cut operation
 * 
 * @author Sabatino
 */
public class CutCommand implements Command{
    
    private Clonator clonator;
    private Shape shape;
    private Pane pane;
    private ContextMenu menu;
    private static final int PASTE_ITEM_INDEX=3;
    
    
    /**
     * CutCommand(Clonator clonator, Shape shape, Pane pane, ContextMenu menu) is the class constructor
     * 
     * @param clonator
     * @param shape
     * @param pane
     * @param menu 
     */
    public CutCommand(Clonator clonator, Shape shape, Pane pane, ContextMenu menu){
        this.clonator = clonator;
        this.shape = shape;
        this.pane = pane;
        this.menu = menu;
    }
    
    /**
     * This method copy a selected shape and delete it from the pane
     */
    @Override
    public void execute() {
        clonator.encodeToXml(shape);
        pane.getChildren().remove(shape);
        menu.getItems().get(PASTE_ITEM_INDEX).setDisable(false);
    }
    
    /**
     * This method restores the previous operation: it adds the eliminated shape
     * on the pane
     */
    @Override
    public void undo() {
        pane.getChildren().add(shape);
        clonator.setByteCloned(null);

    }
    
}
