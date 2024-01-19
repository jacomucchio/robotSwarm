package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import it.unicam.cs.pa.robotSwarm.model.Environment;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.Simulator;
import it.unicam.cs.pa.robotSwarm.model.commands.SignalCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.UnsignalCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulatorTest {
    @Test
    public void testCreateRobots() {
        Environment env = new Environment();
        Simulator sim = new Simulator(env);
        sim.generateRobots(10);
    }
}
