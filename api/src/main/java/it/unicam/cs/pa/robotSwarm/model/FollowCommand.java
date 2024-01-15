package it.unicam.cs.pa.robotSwarm.model;

public class FollowCommand implements ICommand{
    private IRobot robot;
    private IEnvironment environment;
    double dist,speed;
    Point target;
    public FollowCommand(IRobot r, IEnvironment e, ILabel l, double dist, double speed) {
        this.robot=r;
        this.environment=e;
        this.dist=dist;
        this.speed=speed;
        target=environment.getAveragePositionOfRobotsWithLabel(r.getPosition(),l,dist);
    }

    @Override
    public void execute() {
        robot.move(target.getX(), target.getY(), speed);
    }

}
