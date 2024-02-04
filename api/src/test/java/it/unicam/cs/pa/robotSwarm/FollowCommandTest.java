package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import it.unicam.cs.pa.robotSwarm.model.commands.FollowCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.SignalCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FollowCommandTest {
    @Test
    public void shouldExecuteFollowCommand() {
        IRobot robot = new Robot();
        IEnvironment environment = new Environment();
        ILabel label = new BasicLabel("_A");
        FollowCommand followCommand = new FollowCommand(robot, environment, label, 10.0, 2.0);

        assertFalse(followCommand.isExecuted());

        followCommand.execute();

        assertTrue(followCommand.isExecuted());
    }

    @Test
    public void shouldMoveRobotTowardsTarget() {
        IRobot robot1 = new Robot(new Point(0,0),1);
        IRobot robot2 = new Robot(new Point(4,0),1);
        ILabel label = new BasicLabel("_A");

        SignalCommand sc = new SignalCommand(label);
        robot2.addCommand(sc);
        robot2.executeCommand();
        IEnvironment environment = new Environment();
        environment.addRobot(robot1);
        environment.addRobot(robot2);


        FollowCommand followCommand = new FollowCommand(robot1, environment, label, 10.0, 2.0);
        robot1.addCommand(followCommand);
        robot1.executeCommand();

        assertEquals(new Point(2,0),robot1.getPosition());
    }

    @Test
    public void shouldCloneFollowCommand() {
        IEnvironment environment = new Environment();
        ILabel label = new BasicLabel("_A");

        FollowCommand originalCommand = new FollowCommand(environment, label, 10.0, 2.0);
        FollowCommand clonedCommand = originalCommand.clone();

        assertNotSame(originalCommand, clonedCommand);
        assertEquals(originalCommand.toString(), clonedCommand.toString());
    }



}
