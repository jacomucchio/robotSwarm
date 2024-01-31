package it.unicam.cs.pa.robotSwarm;
import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulatorTest {

    @Test
    void generateEnvironment_ShouldGenerateEnvironmentWithGivenNumberOfRobots() {
        Simulator simulator = new Simulator(3);

        Environment result = simulator.generateEnvironment(3);

        assertEquals(3, result.getRobots().size());
    }

    @Test
    void generateRobots_ShouldGenerateListOfRobotsWithGivenSize() {
        Simulator simulator = new Simulator(3);

        List<IRobot> result = simulator.generateRobots(3);

        assertEquals(3, result.size());
    }


    private List<IRobot> generateRobots(int robotNumber) {
        List<IRobot> robots = new ArrayList<>();
        for (int i = 0; i < robotNumber; i++) {
            robots.add(new Robot(-100, 100, -100, 100));
        }
        return robots;
    }
}
