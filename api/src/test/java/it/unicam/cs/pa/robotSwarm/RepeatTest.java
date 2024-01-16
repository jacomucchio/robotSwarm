package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.commands.MoveCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.RepeatCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.SignalCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.StopCommand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {
    @Test
    public void testRepeatOnRobot() {
        Robot r1 = new Robot();
        MoveCommand cm1 = new MoveCommand(r1,1,1,5);
        StopCommand cm2 = new StopCommand(r1);

        List<ICommand> cmdToRepeat = new ArrayList<>();
        cmdToRepeat.add(cm1);
        cmdToRepeat.add(cm2);

        RepeatCommand cm3 = new RepeatCommand(r1, 2, cmdToRepeat);
        SignalCommand cm4 = new SignalCommand(r1,new BasicLabel("_A"));
        r1.addCommand(cm1);
        r1.addCommand(cm2);
        r1.addCommand(cm3);
        r1.addCommand(cm4);
        /*
        r1.addCommand(cm2);

        r1.addCommand(cm3);
        r1.addCommand(cm4);
        for(int i=0;i<5;i++) {
            r1.executeCommand();
        }

         */
        r1.executeCommand();
        r1.executeCommand();
        r1.executeCommand();
        r1.executeCommand();
        r1.executeCommand();
        r1.executeCommand();
        r1.executeCommand();


    }
}
