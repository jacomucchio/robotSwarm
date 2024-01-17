package it.unicam.cs.pa.robotSwarm.io;

import it.unicam.cs.followme.utilities.FollowMeParserHandler;
import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IEnvironment;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.commands.*;

import java.util.ArrayList;
import java.util.List;

public class ParserHandler implements FollowMeParserHandler {
    //TODO i comandi vengono solo aggiunti alla lista ma non assegnati ai robot
    private IRobot robot;
    private List<ICommand> commands;
    private IEnvironment environment;

    public ParserHandler(IRobot robot, IEnvironment environment) {
        this.robot = robot;
        this.commands = new ArrayList<>();
        this.environment=environment;
    }

    @Override
    public void parsingStarted() {
        commands.clear();
    }

    @Override
    public void parsingDone() {

    }

    @Override
    public void moveCommand(double[] args) {
        commands.add(new MoveCommand(robot,args[0],args[1],args[2]));
    }

    @Override
    public void moveRandomCommand(double[] args) {
        commands.add(new MoveRandomCommand(robot,args[0],args[1],args[2],args[3]));
    }

    @Override
    public void signalCommand(String label) {
        commands.add(new SignalCommand(robot,new BasicLabel(label)));
        //TODO cancellare qua sotto
        robot.addCommand(commands.get(0));

    }

    @Override
    public void unsignalCommand(String label) {
        commands.add(new UnsignalCommand(robot,new BasicLabel(label)));
    }

    @Override
    public void followCommand(String label, double[] args) {
        commands.add(new FollowCommand(robot,environment, new BasicLabel(label),args[0],args[1]));
    }

    @Override
    public void stopCommand() {
        commands.add(new StopCommand(robot));
    }

    @Override
    public void continueCommand(int s) {
        //TODO implementare
    }

    @Override
    public void repeatCommandStart(int n) {
        //TODO implementare
    }

    @Override
    public void untilCommandStart(String label) {
        //TODO implementare
    }

    @Override
    public void doForeverStart() {
        //TODO implementare
    }

    @Override
    public void doneCommand() {
        //TODO implementare
    }
}
