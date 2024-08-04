/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

/**
 *
 * @author pasqualecaggiano
 */

import projectapp.singletons.Clonator;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.singletons.SelectedShape;
import projectapp.command.ChangeBorderColorCommand;
import projectapp.command.ChangeInteriorColorCommand;
import projectapp.command.ChangeSizeCommand;
import projectapp.command.CommandExecutor;
import projectapp.command.CopyCommand;
import projectapp.command.CutCommand;
import projectapp.command.DeleteCommand;
import projectapp.command.MirrorCommand;
import projectapp.command.MoveCommand;
import projectapp.command.PasteCommand;
import projectapp.command.ToBackCommand;
import projectapp.command.ToFrontCommand;


/**
 *
 *This SelectionTool class represents the state that allows me to select a 
 *specific figure on which operations will be performed.
 * @author pancraziocirillo
 */

public class SelectionTool extends Tool{
    private final SelectedShape selectedShape;
    private final Clonator clonator;
    private final ContextMenu menu;
    private final VBox vboxChangeSize;
    private static final int HBOX_1 = 0;
    private static final int HBOX_2 = 1;
    private static final int TEXT_FIELD_CHANGE_SIZE = 1;
    
    private double initialPositionX;
    private double initialPositionY;
    private boolean flag;
    private double newX;
    private double newY;
    private double oldX;
    private double oldY;
    private final Group gridContainer;
    
    /**
     * The costructor calls the costructor of Tool class
     * @param pane
     * @param executor
     * Adds an other param that refers to the selectedShape
     * @param selectedShape 
     * @param menu 
     * @param vboxChangeSize 
     * @param gridContainer 
     */
    public SelectionTool(Pane pane,SelectedShape selectedShape,CommandExecutor executor, ContextMenu menu, VBox vboxChangeSize, Group gridContainer) {
        super(pane,executor); 
        this.selectedShape = selectedShape;
        this.clonator = Clonator.getIstance();
        this.menu = menu;
        this.vboxChangeSize = vboxChangeSize;
        this.gridContainer = gridContainer;
    }
    
    public SelectedShape getSelectedShape() {
        return selectedShape;
    }

    public Group getGridContainer() {
        return gridContainer;
    }

    public ContextMenu getMenu() {
        return menu;
    }

    public VBox getVboxChangeSize() {
        return vboxChangeSize;
    }
    
    
    
    /*I need getter method only for tests*/
    public double getNewX() {
        return newX;
    }

    public double getNewY() {
        
        return newY;
    }


    public double getOldX() {
        return oldX;
    }


    public double getOldY() {
        return oldY;
    }

    
    /***
     * This method ensures that when a figure is selected inside the work window, this shape is selected and illuminated.
     * When you then select another figure, the new figure is highlighted and the old figure deselected.
     * @param event this event rappresent the pressed mouse event
     * @param strokeColor is the color that is setted in border picker color
     * @param fillColor is the color that is setted in interior picker color
     */
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        
        if (event.getTarget().getClass()!= getPane().getClass() && (gridContainer == null || !gridContainer.getChildren().contains((Shape) event.getTarget()))){
            vboxChangeSize.visibleProperty().set(false);
            selectedShape.setShape((Shape) event.getTarget()); 
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:5px");
            menu.getItems().forEach(item -> {
                item.setDisable(false);
            });
            
            this.initialPositionX = event.getX();
            this.initialPositionY = event.getY();
            newX = oldX = selectedShape.getShape().getTranslateX();
            newY = oldY = selectedShape.getShape().getTranslateY();
 
        } else {
            
            vboxChangeSize.visibleProperty().set(false);
            selectedShape.setShape(null);
                menu.getItems().forEach(item -> {
                    item.setDisable(true);
                });
            if(clonator.getByteCloned() != null){ 
                menu.getItems().get(3).setDisable(false);
            }    
        }
    }
    
    /**
     * This method allow us to translate the shape simultaneously with the drag of the mouse.
     * At the first iteraction the shape will be translated in place and in 
     * At each iteration the variables newX and newY will be updated taking into account the old position in which the figure was.
     * The operations (oldX + event.getX() - initialPositionX) and (oldY + event.getY() - initialPositionY) allow us to move the figure in linear way 
     * following the mouse drag.
     * 
     * @param event is the mouse drag event on the pane
     */
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(selectedShape.getShape()!=null){
            selectedShape.getShape().setTranslateX(newX);
            selectedShape.getShape().setTranslateY(newY);
            newX = oldX + event.getX() - initialPositionX;
            newY = oldY + event.getY() - initialPositionY;

        }      
    }
    
    /**
     * This method execute a MoveCommand that set the last position of the shape in the pane 
     * indicated by the user with the mouse. Moreover,  we are going to save of what the figure has been translated. 
     * 
     * 
     * @param event is the mouse release event on the pane
     */
    @Override
    public void onMouseReleased(MouseEvent event) {
        if(selectedShape.getShape()!=null && oldX != selectedShape.getShape().getTranslateX() && oldY != selectedShape.getShape().getTranslateY()){
            super.getExecutor().execute(new MoveCommand(selectedShape.getShape(),selectedShape.getShape().getTranslateX(), 
                                        selectedShape.getShape().getTranslateY(), oldX, oldY));
            oldX  = selectedShape.getShape().getTranslateX();
            oldY  = selectedShape.getShape().getTranslateY();   
        }
    }
    
    /***
     * This method allows you to change the border color of a given figure
     * after having selected it
     * @param strokeColor is the color set inside the color border picker.
     */
    @Override
    public void changeBorderColor(Color strokeColor) {
        if (selectedShape.getShape() != null)
            getExecutor().execute(new ChangeBorderColorCommand(selectedShape.getShape(),strokeColor));
    }
    
    /***
     * This method allows you to change the interior color of a given figure 
     * after having selected it
     * @param fillColor is the color set inside the color interior picker.
     */
    @Override
    public void changeInteriorColor(Color fillColor) {
        if (selectedShape.getShape() != null)
            getExecutor().execute(new ChangeInteriorColorCommand(selectedShape.getShape(),fillColor));
    }
    
    @Override
    public void deleteShape() {
        if (selectedShape.getShape() != null)
            getExecutor().execute(new DeleteCommand(selectedShape.getShape(),getPane()));
    }
    
    
    @Override
    public void copy() {
        if (selectedShape.getShape()!= null)
            getExecutor().execute(new CopyCommand(clonator,selectedShape.getShape()));
        else 
            clonator.setByteCloned(null);
        
    }
    
    @Override
    public void paste(Point2D point) {
        if (clonator.getByteCloned()!=null)
            getExecutor().execute(new PasteCommand(clonator,getPane(),point));
        
    }
    
    /**
     * This method will cut (copy+delete) the selected shape
     */
    @Override
    public void cut() {
        if (selectedShape.getShape()!= null)
            getExecutor().execute(new CutCommand(clonator,selectedShape.getShape(), getPane(), menu));
        else 
            clonator.setByteCloned(null);    
    }
    
    /**
     * This method allows you to change the z-axis level of a selected shape 
     */
    @Override
    public void toFront() {
        if (selectedShape.getShape() != null)
            getExecutor().execute(new ToFrontCommand(selectedShape.getShape(), getPane()));
    }
    
    /**
     * This method allows you to change the z-axis level of a selected shape and 
     * allows us to keep the grid under the shapes
     */
    @Override
    public void toBack() {
        if (selectedShape.getShape() != null)
            getExecutor().execute(new ToBackCommand(selectedShape.getShape(), getPane()));
        if (gridContainer != null)
            gridContainer.toBack();
    }
    
    /**
     * This method shows a section in the toolbar in order to
     * modify the size of the selected shape
     */
    @Override
    public void changeSizeBar() {
        vboxChangeSize.visibleProperty().set(true);
    }
    
    /**
     * This method modifies the size of the shape
     * @param changeX
     * @param changeY
     */
    @Override
    public void changeSize(double changeX,double changeY) {
        getExecutor().execute(new ChangeSizeCommand(selectedShape, changeX, changeY, vboxChangeSize));
    }
    
    @Override
    public void mirror() {
        if (selectedShape.getShape() != null)
            getExecutor().execute(new MirrorCommand(selectedShape.getShape()));
    }
    
    /*
     * Unimplemented methods of the abstract class Tool
     */
    @Override
    public Shape getShape() {return null;}

    
}
