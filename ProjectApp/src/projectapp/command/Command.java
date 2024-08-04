/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectapp.command;

/**
 * This class is the command interface that is implemented by each concrete command.
 * @author pasqualecaggiano
 */
public interface Command {
    public void execute(); 
    public void undo();
}
