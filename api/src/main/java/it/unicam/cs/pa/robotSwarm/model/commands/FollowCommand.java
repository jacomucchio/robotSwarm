package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.*;

public class FollowCommand implements ICommand {
    private IRobot robot;
    private IEnvironment environment;
    double dist,speed;
    Point target;
    private boolean isExecuted=false;
    public FollowCommand(IRobot r, IEnvironment e, ILabel l, double dist, double speed) {
        this.robot=r;
        this.environment=e;
        this.dist=dist;
        this.speed=speed;
        //TODO il target cosi viene impostato solo quando viene creato il comando e no ad ogni esecuzione
        target=environment.getAveragePositionOfRobotsWithLabel(r.getPosition(),l,dist);
    }
    public FollowCommand(IEnvironment e, ILabel l, double dist, double speed) {
        this.environment=e;
        this.dist=dist;
        this.speed=speed;
        //TODO il target cosi viene impostato solo quando viene creato il comando e no ad ogni esecuzione
        target=environment.getAveragePositionOfRobotsWithLabel(robot.getPosition(),l,dist);
    }

    @Override
    public void execute() {
        robot.move(target.getX(), target.getY(), speed);
        isExecuted=true;
        System.out.println("sto eseguendo Follow");
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    @Override
    public void setExecuted(boolean executed) {
        this.isExecuted=executed;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }

}
