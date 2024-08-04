/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasqualecaggiano
 */
public class CommandExecutorTest {
    private CommandExecutor executor;
   
    
    @Before
    public void setUp() {
        executor = new CommandExecutor();
    }

    /**
     * Test of execute method, of class CommandExecutor.
     */
    @Test
    public void testExecute() {
        Command drawCommand1 = new DrawCommand(new Line(),new Pane());
        executor.execute(drawCommand1);
        assertEquals(drawCommand1,executor.getStack().getLast());
        
        Command drawCommand2 = new DrawCommand(new Rectangle(),new Pane());
        executor.execute(drawCommand2);
        assertEquals(drawCommand2,executor.getStack().getLast());
        
    }
    
    /**
     * Test of undo method, of class CommandExecutor.
     */
    @Test
    public void testUndo() {
        
        Command drawCommand1 = new DrawCommand(new Line(),new Pane());
        executor.execute(drawCommand1);
        
        Command drawCommand2 = new DrawCommand(new Rectangle(),new Pane());
        executor.execute(drawCommand2);
        
        
        assertEquals(drawCommand2,executor.getStack().getLast());
        
        executor.undo();
        
        assertEquals(drawCommand1,executor.getStack().getLast());  
        
        executor.undo();
        
        assertTrue(executor.getStack().isEmpty());
    }
}
