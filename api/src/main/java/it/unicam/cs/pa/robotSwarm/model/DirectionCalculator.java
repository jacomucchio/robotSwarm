package it.unicam.cs.pa.robotSwarm.model;
/**
 * Utility class for calculating final destination based on initial and target points.
 */
public class DirectionCalculator {
    private Point initialPoint;
    private Point targetPoint;
    private double speed;
    public DirectionCalculator(Point initialPoint, Point targetPoint, double speed) {
        if (initialPoint == null || targetPoint == null) {
            throw new IllegalArgumentException("Initial point and target point cannot be null.");
        }
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative.");
        }
        this.initialPoint = initialPoint;
        this.targetPoint = targetPoint;
        this.speed = speed;
    }

    /**
     * Calculates the final destination point based on the speed and time.
     *
     * @param timeInSeconds The time duration for movement.
     * @return The final destination point.
     */
    public Point calculateFinalDestination(double timeInSeconds) {

        if(speed ==0) return initialPoint;
        double magnitude = Math.sqrt(targetPoint.getX() * targetPoint.getX() + targetPoint.getY() * targetPoint.getY());
        double directionX = (magnitude == 0) ? 0 : targetPoint.getX() / magnitude;
        double directionY = (magnitude == 0) ? 0 : targetPoint.getY() / magnitude;

        double distance = speed * timeInSeconds;

        double finalX = initialPoint.getX() + directionX * distance;
        double finalY = initialPoint.getY() + directionY * distance;

        return new Point(finalX, finalY);
    }

}
