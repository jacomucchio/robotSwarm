package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.commands.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoForeverTest {
    @Test
    void shouldExecuteCommandsInLoopForever() {
        // Arrange
        IRobot robot = new Robot();
        ICommand command1 = new ContinueCommand(1);  // Command that needs to be executed multiple times
        ICommand command2 = new ContinueCommand(1);  // Command that should be executed only once
        List<ICommand> commands = List.of(command1, command2);

        DoForeverCommand doForeverCommand = new DoForeverCommand(robot, commands);
        robot.addCommand(doForeverCommand);
        for (int i = 0; i < 10; i++) {
            robot.executeCommand();
        }
        assertTrue(command1.isExecuted());
        assertTrue(command2.isExecuted());
    }


    @Test
    void shouldResetIterationStatus() {
        IRobot robot = new Robot();
        ICommand command1 = new ContinueCommand(1);  // Command that needs to be executed multiple times
        ICommand command2 = new ContinueCommand(1);  // Command that should be executed only once
        List<ICommand> commands = List.of(command1, command2);

        DoForeverCommand doForeverCommand = new DoForeverCommand(robot, commands);
        robot.addCommand(doForeverCommand);
        // Act
        for (int i = 0; i < 5; i++) {
            robot.executeCommand();
        }

        assertTrue(command1.isExecuted());

        doForeverCommand.resetStatus();

        assertFalse(command2.isExecuted());
    }
}
