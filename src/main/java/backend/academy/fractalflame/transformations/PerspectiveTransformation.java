package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class PerspectiveTransformation extends Transformation {

    private final double angle;
    private final double dist;

    public PerspectiveTransformation(double angle, double dist, int r, int g, int b) {
        super(r, g, b);
        this.angle = angle;
        this.dist = dist;
    }

    @Override
    @SuppressWarnings("all")
    public Point apply(Point p) {
        double sinP1 = Math.sin(angle);
        double cosP1 = Math.cos(angle);

        double denominator = dist - p.y() * sinP1;
        if (Math.abs(denominator) < 1e-6) {
            denominator = 1e-6;
        }
        double factor = dist / denominator;
        double newX = factor * p.x();
        double newY = factor * (p.y() * cosP1);

        return new Point(newX, newY, red, green, blue);
    }
}
