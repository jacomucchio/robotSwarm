package it.unicam.cs.pa.robotSwarm.model;

public class DirectionCalculator {
    private Point starting;
    private Point target;
    private double speed;
    public DirectionCalculator(Point starting, Point target, double speed) {
        if (starting == null || target == null) {
            throw new IllegalArgumentException("Starting point and target cant be null.");
        }
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cant be negative");
        }
        this.starting = starting;
        this.target = target;
        this.speed=speed;
    }
    public Point calculateFinalDestination(double timeInSeconds) {

        if(speed ==0) return starting;
        double magnitude = Math.sqrt(target.getX() * target.getX() + target.getY() * target.getY());
        double directionX = (magnitude == 0) ? 0 : target.getX() / magnitude;
        double directionY = (magnitude == 0) ? 0 : target.getY() / magnitude;

        // Calcola la distanza totale basata sulla velocità e sul tempo
        double distance = speed * timeInSeconds;

        // Calcola il punto finale basato sulla distanza e sulla direzione
        double finalX = starting.getX() + directionX * distance;
        double finalY = starting.getY() + directionY * distance;

        return new Point(finalX, finalY);
    }
    /*
        if (speed == 0) return starting;

        // Calcola la direzione del movimento come differenza tra target e starting
        double diffX = target.getX() - starting.getX();
        double diffY = target.getY() - starting.getY();

        // Calcola la magnitudine (lunghezza) del vettore direzione
        double magnitude = Math.sqrt(diffX * diffX + diffY * diffY);

        // Normalizza il vettore direzione
        double directionX = (magnitude == 0) ? 0 : diffX / magnitude;
        double directionY = (magnitude == 0) ? 0 : diffY / magnitude;

        // Calcola la distanza totale basata sulla velocità e sul tempo
        double distance = speed * timeInSeconds;

        // Calcola il punto finale basato sulla distanza e sulla direzione
        double finalX = starting.getX() + directionX * distance;
        double finalY = starting.getY() + directionY * distance;

        return new Point(finalX, finalY);
        */

}
