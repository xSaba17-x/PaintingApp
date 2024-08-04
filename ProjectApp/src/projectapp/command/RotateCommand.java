/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import projectapp.singletons.SelectedShape;

/**
 *
 * @author Sabatino
 */
public class RotateCommand implements Command{
    
    private SelectedShape selectedShape;
    private double initialRotate;
    private double endRotate;
    
    public RotateCommand(SelectedShape selectedShape, double initialRotate, double endRotate){
        this.selectedShape = selectedShape;
        this.initialRotate = initialRotate;
        this.endRotate = endRotate;
    }

    @Override
    public void execute() {
        selectedShape.getShape().setRotate(endRotate);
    }

    @Override
    public void undo() {
        selectedShape.getShape().setRotate(initialRotate);
    }
    
}
