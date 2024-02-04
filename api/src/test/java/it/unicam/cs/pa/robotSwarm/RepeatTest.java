package it.unicam.cs.pa.robotSwarm;
import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.Point;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.commands.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatTest {
    @Test
    public void shouldExecuteCommandsRepeatedly() {
        Robot robot = new Robot();

        List<ICommand> commands = new ArrayList<>();
        commands.add(new MoveCommand(robot, 1.0, 0.0, 1.0));
        commands.add(new MoveCommand(robot, -1.0, 0.0, 1.0));

        RepeatCommand repeatCommand = new RepeatCommand(robot, 2, commands);
        robot.addCommand(repeatCommand);

        for(int i=0; i<2; i++) {
            robot.executeCommand();
            assertEquals(new Point(1.0, 0), robot.getPosition());

            robot.executeCommand();
            assertEquals(new Point(0, 0), robot.getPosition());
        }

    }
    @Test
    public void shouldRepeatARepeat() {
        Robot robot = new Robot();

        List<ICommand> commandsForRepeat1 = new ArrayList<>();
        commandsForRepeat1.add(new MoveCommand(1.0, 0.0, 1.0));
        commandsForRepeat1.add(new MoveCommand(-1.0, 0.0, 1.0));
        RepeatCommand repeat1 = new RepeatCommand( 2, commandsForRepeat1);

        List<ICommand> commandsForRepeat2 = new ArrayList<>();
        commandsForRepeat2.add(repeat1);

        RepeatCommand repeat2 = new RepeatCommand(robot,2,commandsForRepeat2 );
        robot.addCommand(repeat2);

        for(int i=0; i<4; i++) {
            robot.executeCommand();
            System.out.println(robot.getPosition());
            assertEquals(new Point(1.0, 0), robot.getPosition());

            robot.executeCommand();
            System.out.println(robot.getPosition());

            assertEquals(new Point(0, 0), robot.getPosition());
        }

    }
    @Test
    public void shouldThrowExceptionForInvalidParameters() {
        Robot r = new Robot();
        List<ICommand>cmd = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new RepeatCommand(r, 2, cmd));
        cmd.add(new MoveCommand(1,1,5));
        assertThrows(IllegalArgumentException.class, () -> new RepeatCommand(r, 0, cmd));
    }

}
