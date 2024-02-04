package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Point;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.commands.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoForeverTest {
    @Test
    void shouldExecuteCommandsInLoopForever() {
        IRobot robot = new Robot();
        ICommand command1 = new ContinueCommand(1);
        ICommand command2 = new ContinueCommand(1);
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
        ICommand command1 = new MoveCommand(1,0,1);
        ICommand command2 = new StopCommand();
        List<ICommand> commands = List.of(command1, command2);

        DoForeverCommand doForeverCommand = new DoForeverCommand(robot, commands);
        robot.addCommand(doForeverCommand);
        for (int i = 0; i < 3; i++) {
            robot.executeCommand();
        }

        assertEquals(new Point(2,0),robot.getPosition());

    }
}
