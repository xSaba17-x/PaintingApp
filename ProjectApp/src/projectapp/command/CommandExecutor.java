/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import java.util.*;

/**
 * This class is the invoker of the command design pattern and executes the commands.
 * @author acoon
 */
public class CommandExecutor {
    private final Deque<Command> stack;
    
    public CommandExecutor(){
        stack = new ArrayDeque();
    }

    public Deque<Command> getStack() {
        return stack;
    }
    
    public void execute(Command command){
        stack.addLast(command);
        command.execute();
    }
    
    public void undo(){
        Command command = stack.removeLast();
        command.undo();
    }
   
}
