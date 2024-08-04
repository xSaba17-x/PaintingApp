/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.singletons;

import javafx.scene.shape.Shape;

/**
 * This class allows us to have a single reference to the selected shape, and to change 
 * the real selected shape when the user selects a new shape from the drawing pane
 * 
 * @author pasqualecaggiano
 */
public class SelectedShape {
    private Shape shape;

    static private SelectedShape instance=null; 
    
    
    public SelectedShape(){
        shape = null;
    }
    
    public static SelectedShape getIstance() {
      if (instance==null)
         instance=new SelectedShape();
      return instance;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
