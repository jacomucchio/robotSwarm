package it.unicam.cs.pa.robotSwarm;
import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulatorTest {


    @Test
    void shouldCreateSimulatorWithEnvironmentAndRobots() {
        int robotNumber = 3;

        Simulator simulator = new Simulator(robotNumber);
        simulator.simulate(1,1);
        assertNotNull(simulator.getEnvironment());
        assertEquals(robotNumber, simulator.getEnvironment().getRobots().size());
    }

    @Test
    void shouldGenerateEnvironmentWithSpecifiedNumberOfRobots() {
        int robotNumber = 4;
        Simulator simulator = new Simulator(robotNumber);


        simulator.simulate(1,1);
        IEnvironment environment = simulator.getEnvironment();
        assertEquals(robotNumber, environment.getRobots().size());
    }

    @Test
    void shouldGenerateListOfRobotsWithSpecifiedNumberOfRobots() {
        int robotNumber = 3;
        Simulator simulator = new Simulator(robotNumber);
        List<IRobot> robots = simulator.generateRobots(robotNumber,1);

        assertEquals(robotNumber, robots.size());
    }

}
