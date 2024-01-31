package it.unicam.cs.pa.robotSwarm;
import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimulatorTest {


    @Test
    void shouldCreateSimulatorWithEnvironmentAndRobots() {
        int robotNumber = 3;

        Simulator simulator = new Simulator(robotNumber);

        assertNotNull(simulator.getEnvironment());
        assertEquals(robotNumber, simulator.getEnvironment().getRobots().size());
    }



    @Test
    void shouldGenerateEnvironmentWithSpecifiedNumberOfRobots() {
        int robotNumber = 4;
        Simulator simulator = new Simulator(robotNumber);
        IEnvironment environment = simulator.getEnvironment();

        assertNotNull(environment);
        assertEquals(robotNumber, environment.getRobots().size());
    }

    @Test
    void shouldGenerateListOfRobotsWithSpecifiedNumberOfRobots() {
        int robotNumber = 3;
        Simulator simulator = new Simulator(robotNumber);
        List<IRobot> robots = simulator.generateRobots(robotNumber);

        assertEquals(robotNumber, robots.size());
    }

}
