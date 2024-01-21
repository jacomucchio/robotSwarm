package it.unicam.cs.pa.robotSwarm.io;

import it.unicam.cs.followme.utilities.FollowMeParserHandler;
import it.unicam.cs.pa.robotSwarm.model.*;
import it.unicam.cs.pa.robotSwarm.model.commands.*;

import java.util.ArrayList;
import java.util.List;

public class ProgramParserHandler implements FollowMeParserHandler {
    private IEnvironment environment;
    private List<ICommand>parsedCommands;

    private List<IIterativeCommands> iterativeInstructions;

    public ProgramParserHandler(IEnvironment environment) {
        this.environment=environment;
        this.iterativeInstructions=new ArrayList<>();
        this.parsedCommands=new ArrayList<>();

    }

    @Override
    public void parsingStarted() {
        System.out.println("Parsing Iniziato");
    }

    @Override
    public void parsingDone() {
        System.out.println("Parsing Completato");
        for(IRobot r:environment.getRobots())
        {
            System.out.println("il comando parsato è stato assegnato al robot alla posizione "+r.getPosition());
            for(ICommand command: parsedCommands){
                r.addCommand(command);
            }
        }
    }

    @Override
    public void moveCommand(double[] args) {
        MoveCommand mc = new MoveCommand(args[0], args[1], args[2]);
        if(iterativeInstructions.isEmpty()) {
            parsedCommands.add(mc);
        } else{
            iterativeInstructions.get(iterativeInstructions.size()-1).addCommand(mc);
        }
    }

    @Override
    public void moveRandomCommand(double[] args) {
        MoveRandomCommand mrc = new MoveRandomCommand(args[0],args[1],args[2],args[3]);
        if(iterativeInstructions.isEmpty()) {
            parsedCommands.add(mrc);
        } else{
            iterativeInstructions.get(iterativeInstructions.size()-1).addCommand(mrc);
        }
    }

    @Override
    public void signalCommand(String label) {
        SignalCommand sc = new SignalCommand(new BasicLabel(label));
        if(iterativeInstructions.isEmpty()) {
            parsedCommands.add(sc);
        } else{
            iterativeInstructions.get(iterativeInstructions.size()-1).addCommand(sc);
        }
    }

    @Override
    public void unsignalCommand(String label) {
        UnsignalCommand uc = new UnsignalCommand(new BasicLabel(label));
        if(iterativeInstructions.isEmpty()) {
            parsedCommands.add(uc);
        } else{
            iterativeInstructions.get(iterativeInstructions.size()-1).addCommand(uc);
        }
    }

    @Override
    public void followCommand(String label, double[] args) {
        FollowCommand fc = new FollowCommand(environment, new BasicLabel(label),args[0],args[1]);
        if(iterativeInstructions.isEmpty()) {
            parsedCommands.add(fc);
        } else{
            iterativeInstructions.get(iterativeInstructions.size()-1).addCommand(fc);
        }

    }

    @Override
    public void stopCommand() {
        StopCommand stop = new StopCommand();
        if(iterativeInstructions.isEmpty()) {
            parsedCommands.add(stop);
        } else{
            iterativeInstructions.get(iterativeInstructions.size()-1).addCommand(stop);
        }
    }

    @Override
    public void continueCommand(int s) {
        ContinueCommand cc = new ContinueCommand(s);
        if(iterativeInstructions.isEmpty()) {
            parsedCommands.add(cc);
        } else{
            iterativeInstructions.get(iterativeInstructions.size()-1).addCommand(cc);
        }
    }

    @Override
    public void repeatCommandStart(int n) {
        /*
        TODO modificare in modo tale che venga creato un comando generico
             e non specifico per ogni robot
         */
        iterativeInstructions.add(new RepeatCommand(n));


    }

    @Override
    public void untilCommandStart(String label) {
        //TODO implementare
        iterativeInstructions.add(new UntilCommand(new BasicLabel(label),environment));
    }

    @Override
    public void doForeverStart() {
        //TODO implementare
        iterativeInstructions.add(new DoForeverCommand());
    }

    @Override
    public void doneCommand() {

        if(iterativeInstructions.size()>1)
        {
            iterativeInstructions.get(iterativeInstructions.size()-2).
                    addCommand(iterativeInstructions.get(iterativeInstructions.size()-1));
            iterativeInstructions.remove(iterativeInstructions.size()-1);
        }else{
            parsedCommands.add(iterativeInstructions.get(0));
            iterativeInstructions.remove(0);
        }

    }
    public IEnvironment getEnvironment(){
        return environment;
    }

}
