package it.unicam.cs.pa.robotSwarm.model;

public class DirectionCalculator {
    private Point starting;
    private Point target;
    private double speed;
    public DirectionCalculator(Point starting, Point target, double speed) {
        this.starting = starting;
        this.target = target;
        this.speed=speed;
    }
    public Point CalculateDirection(){
        // Calcola la direzione del movimento
        double directionX = target.getX() - starting.getX();
        double directionY = target.getY() - starting.getY();

        // Normalizza il vettore direzione
        double magnitude = Math.sqrt(directionX * directionX + directionY * directionY);
        directionX /= magnitude;
        directionY /= magnitude;

        // Calcola il punto finale basato sulla velocità e sulla direzione
        double finalX = starting.getX() + directionX * speed;
        double finalY = starting.getY() + directionY * speed;

        return new Point(finalX, finalY);
    }
}
