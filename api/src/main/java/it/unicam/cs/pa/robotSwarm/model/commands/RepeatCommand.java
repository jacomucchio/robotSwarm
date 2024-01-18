package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Robot;

import java.util.ArrayList;
import java.util.List;

public class RepeatCommand implements IIterativeCommands {
    private IRobot robot;
    private boolean isExecuted=false;
    private int iterations; //contatore iterazione
    private int icounter; //contatore istruzioni
    private List<ICommand> commands;
    private int repetitions;

    public RepeatCommand(IRobot robot, int i, List<ICommand> commands) {
        this.robot = robot;
        this.iterations=i;
        this.commands=commands;
        this.repetitions=i;
    }

    public RepeatCommand(IRobot robot, int i) {
        this.robot = robot;
        this.iterations=i;
        this.commands=new ArrayList<>();
        this.repetitions=i;
    }
    public RepeatCommand(int i) {
        this.iterations=i;
        this.commands=new ArrayList<>();
        this.repetitions=i;
    }
    @Override
    public void execute() {
        //System.out.println("sto eseguendo Repeat");
        commands.get(icounter).execute();
        checkIterationStatus();
    }
    //TODO aggiungere checkIterationStatus() all'interfaccia IIterativeCommands
    public void checkIterationStatus() {
        /*
        if(commands.get(icounter) instanceof RepeatCommand rp)
        {
            System.out.println("sto controllando");
            if(!rp.isExecuted){
                System.out.println("Deve finire l'iterazione");
                return;
            } else{
                rp.resetStatus();
            }
        }
        */
        /*
        Controllo se il comando che è stato eseguito è un comando iterativo
        In caso affermativo se quel comando non ha completato l'esecuzione
        della lista di comandi che deve eseguire non viene incrementato il contatore
        delle istruzioni in modo tale da continuare ad esguire il comando finchè non
        ha completato l'esecuzione
         */
        if (commands.get(icounter) instanceof IIterativeCommands ic) {
            if(!ic.isExecuted()){
                return;
            } else ic.resetStatus();
        }

        if(icounter==commands.size()-1){
            if(iterations>1){
                iterations--;
                icounter=0;
            }
            else isExecuted=true;
        } else icounter++;
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
        for(ICommand cmd: commands)
        {
            cmd.setReceiver(receiver);
        }
    }
    @Override
    public void addCommand(ICommand command)
    {
        this.commands.add(command);
    }
    public List<ICommand> getCommandList()
    {
        return commands;
    }
    /*
    TODO metodo che può essere utile per resettare lo stato dei comandi iterativi se
         devono essere ripetuti
     */
    @Override
    public void resetStatus()
    {
        this.icounter=0;
        this.iterations=repetitions;
        this.isExecuted=false;
    }
}
