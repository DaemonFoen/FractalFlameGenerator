package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class SecantTransformation extends Transformation {

    private final double v46;

    public SecantTransformation(double v46, int r, int g, int b) {
        super(r, g, b);
        this.v46 = v46;
    }

    @Override
    @SuppressWarnings("all")
    public Point apply(Point p) {
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());

        double denominator = Math.cos(v46 * r);
        if (Math.abs(denominator) < 1e-6) {
            denominator = 1e-6;
        }
        double newX = p.x();
        double newY = 1.0 / denominator;

        return new Point(newX, newY, red, green, blue);
    }
}
