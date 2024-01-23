package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.*;

public class FollowCommand implements ICommand, Cloneable{
    private IRobot robot;
    private IEnvironment environment;
    double dist,speed;
    Point target;
    ILabel label;
    private boolean isExecuted=false;
    public FollowCommand(IRobot r, IEnvironment e, ILabel label, double dist, double speed) {
        this.robot=r;
        this.environment=e;
        this.dist=dist;
        this.speed=speed;
        this.label=label;
    }
    public FollowCommand(IEnvironment e, ILabel label, double dist, double speed) {
        this.environment=e;
        this.dist=dist;
        this.speed=speed;
        this.label=label;
    }

    public FollowCommand(ILabel label, double dist, double speed) {
        this.dist=dist;
        this.speed=speed;
        this.label=label;
    }

    @Override
    public void execute() {
        target=environment.getAveragePositionOfRobotsWithLabel(robot.getPosition(),label,dist);
        robot.move(target.getX(), target.getY(), speed);
        isExecuted=true;
        System.out.println("sto eseguendo Follow");
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }

    @Override
    public FollowCommand clone() {
        try {
            FollowCommand clonedCommand = (FollowCommand) super.clone();
            clonedCommand.environment = this.environment;
            // Clona l'ambiente se implementa Cloneable
            // clonedCommand.environment = this.environment.clone(); // da implementare in IEnvironment
            // Clona l'IRobot se implementa Cloneable
            // clonedCommand.robot = this.robot.clone(); // da implementare in IRobot

            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

}
