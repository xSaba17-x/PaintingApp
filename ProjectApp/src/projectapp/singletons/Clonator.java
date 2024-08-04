/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.singletons;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author pasqualecaggiano
 */
public class Clonator {
    private byte[] byteCloned;  
    static private Clonator instance = null; 
    
    
    public Clonator(){
        byteCloned = null;
    }
    
    public static Clonator getIstance() {
      if (instance == null)
         instance = new Clonator();
      return instance;
	}

    public void setByteCloned(byte[] byteCloned) {
        this.byteCloned = byteCloned;
    }

    public byte[] getByteCloned() {
        return byteCloned;
    }
    
    
    public void encodeToXml(Shape shape){
        
        shape.setStyle("-fx-stroke-dash-array:none");
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
        
        try(XMLEncoder encoder = new XMLEncoder(stream)){
            encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red","green","blue","opacity"}));
            encoder.writeObject(shape);
        }
       
        byteCloned = stream.toByteArray();
        
    }
    
    public Shape decodeFromXml(){
        Shape shape;
        ByteArrayInputStream stream = new ByteArrayInputStream(byteCloned);

        try(XMLDecoder decoder = new XMLDecoder(stream)){
            shape = (Shape) decoder.readObject(); 
        }
         
        return shape;
    }
    
    
    
}
