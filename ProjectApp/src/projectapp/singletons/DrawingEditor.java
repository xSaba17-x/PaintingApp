/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.singletons;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import projectapp.FXMLDocumentController;
import projectapp.Grid;
import projectapp.command.CommandExecutor;
import projectapp.tools.EllipseTool;
import projectapp.tools.LineTool;
import projectapp.tools.RectangleTool;
import projectapp.tools.RotateTool;
import projectapp.tools.SelectionTool;
import projectapp.tools.Tool;


/**
 * This method is the only entry point for the communication between the controller (FXMLDocumentController) and 
 * the Model.
 * @author pasqualecaggiano
 */
public class DrawingEditor {
    
    
    private final Pane drawingPane;
    
    private final CommandExecutor executor;

    private Tool currentTool;
    
    private final SelectedShape selectedShape;
    
    private final ContextMenu menu;
    
    static private DrawingEditor instance = null;
    
    private final VBox vboxChangeSize;
    
    private Grid grid;
    private Group gridContainer;
    /**
     * 
     * DrawingEditor(Pane pane, CommandExecutor executor,Tool currentTool) is the class costructor
     * 
     * @param pane is the reference to the drawing pane
     * @param executor is the reference to the commands' invoker
     * @param currentTool is the current state of the draing editor
     * @param menu
     */

    public DrawingEditor(Pane pane, CommandExecutor executor,Tool currentTool, ContextMenu menu, VBox vboxChangeSize) {
        this.drawingPane = pane;
        this.executor = executor;
        this.currentTool = currentTool;
        this.selectedShape = SelectedShape.getIstance();
        this.menu = menu;
        this.vboxChangeSize = vboxChangeSize;
        this.grid = new Grid();
    }
    
    public static DrawingEditor getIstance(Pane pane, CommandExecutor executor,Tool currentTool, ContextMenu menu, VBox vboxChangeSize){
        if (instance == null)
         instance = new DrawingEditor(pane,executor,currentTool, menu, vboxChangeSize);
      return instance;
    }
    
    //create only for test
    public Tool getCurrentTool() {
        return currentTool;
    }

    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the line button in the application. This condition is necessary for draw a line.
     */
    public void setLineTool(){
        vboxChangeSize.visibleProperty().set(false);
        if (selectedShape.getShape() != null){
           selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new LineTool(drawingPane,executor, menu);
    }
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the rectangle button in the application. This condition is necessary for draw a rectangle.
     */
    public void setRectangleTool(){
        vboxChangeSize.visibleProperty().set(false);
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        
        currentTool = new RectangleTool(drawingPane,executor, menu);
    }
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the ellipse button in the application. This condition is necessary for draw an ellipse.
     */
    public void setEllipseTool(){
        vboxChangeSize.visibleProperty().set(false);
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new EllipseTool(drawingPane,executor, menu);
    }
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the selection button in the application. This condition is necessary for select a shape.
     */
    public void setSelectionTool(){
        vboxChangeSize.visibleProperty().set(false);
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none"); 
        }
        currentTool = new SelectionTool(drawingPane,selectedShape,executor, menu, vboxChangeSize, gridContainer);
    }  
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the selection button in the application. This condition is necessary for rotate a shape.
     */
    public void setRotateTool(){
        
        currentTool = new RotateTool(drawingPane,selectedShape,executor, menu, vboxChangeSize, gridContainer);
    }  
    
    
    /**
     * {@link projectapp.FXMLDocumentController#onMousePressed(javafx.scene.input.MouseEvent)}
     * @param event is the mouse event detected from the FXMLController
     * @param strokeColor is the border color of the borderPicker
     * @param fillColor is the interior color of the interioPicker
     */
    public void onMousePressed(MouseEvent event,Color strokeColor, Color fillColor){
        currentTool.onMousePressed(event, strokeColor, fillColor);
    }
    
    /**
     * {@link projectapp.FXMLDocumentController#onMouseDragged(javafx.scene.input.MouseEvent)}
     * @param event is the mouse event detected from the FXMLController
     * 
     */
    public void onMouseDragged(MouseEvent event){
        currentTool.onMouseDragged(event);
    }
    
    /**
     * {@link projectapp.FXMLDocumentController#onMouseReleased(javafx.scene.input.MouseEvent)}
     * @param event is the mouse event detected from the FXMLController
     * 
     */
    public void onMouseReleased(MouseEvent event){
        currentTool.onMouseReleased(event);
        
    }
    
    /***
     * This method allows the user to change the border color of a given figure. 
     * @param strokeColor is the color set inside the color border picker.
     */
    public void changeBorderColor(Color strokeColor){
        currentTool.changeBorderColor(strokeColor);
    }
    /***
     * This method allows the user to change the interior color of a given figure.
     * @param fillColor is the color set inside the color interior picker.
     */
    public void changeInteriorColor(Color fillColor){
        currentTool.changeInteriorColor(fillColor);
    }
    
    /***
     * This method allows the user to delete the selected figure.
     */
    public void deleteShape(){
        vboxChangeSize.visibleProperty().set(false);
        currentTool.deleteShape();
    }
    
    /**
     * This method allows the user to use a section in the toolbar in order to
     * change the size of a selected shape
     */
    public void changeSizeBar(){
        currentTool.changeSizeBar();
    }
    
    /**
     * This method allows the user to change the size of a selected shape
     * @param changeX
     * @param changeY
     */
    public void changeSize(double changeX,double changeY){
        currentTool.changeSize(changeX,changeY);
    }
    
    
    /***
     * This method allows the user to bring the shape in foreground.
     */
    public void toFront(){
        currentTool.toFront();
    }
    public void toBack(){
        currentTool.toBack();
    }
    
    /***
     * This method allows the user to copy the selected figure.
     */
    public void copyShape(){
        currentTool.copy();
    }
    
    /***
     * This method allows the user to paste the selected figure.
     */
    public void pasteShape(Point2D point){
        currentTool.paste(point);
    }
    
    /***
     * This method allows the user to cut the selected figure.
     */
    public void cutShape(){
        currentTool.cut();
    }
    
    /**
     * This method allows the user to undo the previous operation on a shape
     */
    public void undo(){
        try{
        executor.undo();
        }catch (Exception e){
            
        }
    }
    /**
     * This method allows you to save the current drawing on an XML file.
     * @param file is the location chosen by the user on his file system
     */
    public void saveDrawing(File file){
        Group grid = null;
        if(drawingPane.getChildren().get(0) instanceof Group){
            grid = (Group) drawingPane.getChildren().remove(0);
        }
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file))){
                    
                    encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red","green","blue","opacity"}));
                    
                    encoder.writeObject(drawingPane.getChildren().toArray(new Node[0]));
                   
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);    
                } 
        if(grid != null){
            drawingPane.getChildren().add(0, grid);
        }
    }
    
    /**
     * This method allows you to load a previous saved drawing from an XML file.
     * @param file is the xml file chosen by the user to load
     */
    public void loadDrawing(File file){
        
        drawingPane.getChildren().clear();
                
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(file))){
            drawingPane.getChildren().addAll((Node[]) decoder.readObject());  

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * This method creates a grid and add it to the drawing pane in the first position.
     * in this way the grid will be positioned under all the shapes contained in the draw.
     * @param size is the size of the grid choosen by the user.
     */
    public Group addGrid(Double size){
        try{
            gridContainer = grid.create(drawingPane, size);
            drawingPane.getChildren().add(0, gridContainer);
            if(currentTool instanceof SelectionTool){
                setSelectionTool();
            }
            return gridContainer;
        }catch(Exception e){
            return null;
        }
    }
     
    /**
     * This method removes the grid from the drawing pane, since the grid is always 
     * below all other figures, it will certainly be in position 0.
     */
    public Group removeGrid(){
        try{
            gridContainer = (Group)drawingPane.getChildren().remove(0);
            if(currentTool instanceof SelectionTool){
                setSelectionTool();
            }
            return gridContainer;
        }catch(Exception e){
            return null;
        }
    }
    
    /**
     * This method allows to zoom in or zoom out the drawing according to the specific button pressed
     * @param type 
     */
    public void zoom(boolean type){
        ZoomPane.getIstance().zoom(type);
    }
    
    /**
     * This method allow you to mirror a selected shape.
     */
    public void mirror(){
        currentTool.mirror();
    }
}
