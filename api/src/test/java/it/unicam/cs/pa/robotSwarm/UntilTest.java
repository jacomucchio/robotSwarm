package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import it.unicam.cs.pa.robotSwarm.model.commands.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UntilTest {
    @Test
    public void testShouldExecuteUntilLabel() {
        Robot r1 = new Robot();
        Circle c1= new Circle(new Point(0,0),10,new BasicLabel("_A"));

        Environment env= new Environment();
        env.addArea(c1);
        env.addRobot(r1);

        MoveCommand cm1 = new MoveCommand(r1,1,1,5);
        StopCommand cm2 = new StopCommand(r1);

        List<ICommand> cmdToRepeat = new ArrayList<>();
        cmdToRepeat.add(cm1);
        cmdToRepeat.add(cm2);

        UntilCommand cm3 = new UntilCommand(r1,new BasicLabel("_A"),env,cmdToRepeat);
        SignalCommand cm4 = new SignalCommand(r1,new BasicLabel("_A"));
        r1.addCommand(cm1);
        r1.addCommand(cm2);
        r1.addCommand(cm3);
        r1.addCommand(cm4);

        r1.executeCommand();
        r1.executeCommand();
        r1.executeCommand();
        r1.executeCommand();
        assertEquals(new BasicLabel("_A"), r1.getLabel());

    }
    @Test
    public void testShouldNotStopExecutionUntilInsideArea() {
        Robot r1 = new Robot();
        Circle c1= new Circle(new Point(6,0),1,new BasicLabel("_A"));

        Environment env= new Environment();
        env.addArea(c1);
        env.addRobot(r1);

        MoveCommand cm1 = new MoveCommand(r1,1,0,1);

        List<ICommand> cmdToRepeat = new ArrayList<>();
        cmdToRepeat.add(cm1);

        UntilCommand cm3 = new UntilCommand(r1,new BasicLabel("_A"),env,cmdToRepeat);

        r1.addCommand(cm3);

        for(int i=0;i<6;i++) {
            r1.executeCommand();
        }
        assertEquals(new Point (5,0),r1.getPosition());

    }



}
