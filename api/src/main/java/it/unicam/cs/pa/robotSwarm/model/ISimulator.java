package it.unicam.cs.pa.robotSwarm.model;

/**
 * An interface representing a simulator for robotic swarm simulation.
 */
public interface ISimulator {
    /**
     * Simulates the robotic swarm for a specified duration and total time.
     *
     * @param dt The time step for each simulation iteration.
     * @param time The total simulation time.
     */
    void simulate(double dt, double time);
}
