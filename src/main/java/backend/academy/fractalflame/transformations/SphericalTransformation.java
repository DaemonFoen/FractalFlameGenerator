package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class SphericalTransformation extends Transformation {

    public SphericalTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    @SuppressWarnings("all")
    public Point apply(Point p) {
        double r2 = p.x() * p.x() + p.y() * p.y();
        if (r2 == 0) {
            r2 = 1e-6;
        }
        double newX = p.x() / r2;
        double newY = p.y() / r2;
        return new Point(newX, newY, red, green, blue);
    }
}
