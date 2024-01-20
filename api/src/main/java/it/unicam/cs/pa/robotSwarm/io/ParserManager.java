package it.unicam.cs.pa.robotSwarm.io;

import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.ShapeData;
import it.unicam.cs.pa.robotSwarm.model.IArea;
import it.unicam.cs.pa.robotSwarm.model.IEnvironment;
import it.unicam.cs.pa.robotSwarm.model.ShapeDataAreaFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParserManager {
    //percorso del file contenente il programma
    private File programPath;

    //percorso del file contenente le aree
    private File areasPath;
    private IEnvironment environment;

    private FollowMeParser parser;

    public ParserManager(File programPath, File areasPath, IEnvironment environment) {
        this.programPath = programPath;
        this.areasPath = areasPath;
        this.environment=environment;
        parser = new FollowMeParser(new ProgramParserHandler(environment));
    }
    public void executeParsing(){
        executeProgramParsing();
        executeAreaParsing();
    }

    //effettua il parsing del programma ed assegna i comandi ad ogni robot che sta nell'environment
    private void executeProgramParsing(){
        try {
            parser.parseRobotProgram(programPath);
            System.out.println("ho letto il file del programma");
        } catch (Exception e) {
            e.printStackTrace();
            // Gestisci eventuali eccezioni qui
        }
    }
    private void executeAreaParsing(){
        ShapeDataAreaFactory areaFactory = new ShapeDataAreaFactory();
        List<IArea> areas = new ArrayList<>();
        try {
            List<ShapeData> parsedShapeData = parser.parseEnvironment(areasPath);
            for (ShapeData shapeData : parsedShapeData) {
                areas.add(areaFactory.createArea(shapeData));
            }
            environment.addAreas(areas);
            System.out.println("ho letto il file delle aree");
        } catch (Exception e) {
            e.printStackTrace();
            // Gestisci eventuali eccezioni qui
        }

    }
}
