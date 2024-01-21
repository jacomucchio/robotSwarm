package it.unicam.cs.pa.robotSwarm;
import it.unicam.cs.pa.robotSwarm.model.Environment;
import it.unicam.cs.pa.robotSwarm.model.Simulator;
import org.junit.jupiter.api.Test;

public class SimulatorTest {
    @Test
    public void testCreateRobots() {
        Simulator sim = new Simulator(2);
        sim.simulate(1,10);
    }
}
