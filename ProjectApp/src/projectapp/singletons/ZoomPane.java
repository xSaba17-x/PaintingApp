/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.singletons;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;


/**
 * This class create a pane that allows to zoom in the scroll pane.
 * @author pasqualecaggiano
 */
public class ZoomPane extends Pane{
        public static final double DEFAULT_DELTA = 1.3d; 
        public static final double LOWER_BOUND = 0.2d;
        public static final double UPPER_BOUND = 6d;
        DoubleProperty myScale = new SimpleDoubleProperty(1.0);
        
        private static ZoomPane instance = null;
        
        public static ZoomPane getIstance(){  
            if (instance==null)
               instance = new ZoomPane();
            return instance;
        }
        
        /**
         *  Class constructor that bind the scale property of the pane with the current scale 
         *  and create the timeline
         */
        
        public ZoomPane() {
            scaleXProperty().bind(myScale);
            scaleYProperty().bind(myScale);
        }


        public double getScale() {
            return myScale.get();
        }
        
        public void setScale(double scale){
            myScale.set(scale);
        }
        
        /**
         * This method perform the zoom operation:
         * - zoom-in if type is true
         * - zoom-out if type is false
         * 
         * @param type 
         */
        public void zoom(boolean type){
            double scale = this.getScale(); 
            double oldScale = scale;

            if (!type) {
                scale /= DEFAULT_DELTA;
            } else {
                scale *= DEFAULT_DELTA;
            }
            
            if (scale >= LOWER_BOUND && scale <= UPPER_BOUND){
                this.setScale(scale);
            } else {
                this.setScale(oldScale);
            }
  
        }
        
     
}



