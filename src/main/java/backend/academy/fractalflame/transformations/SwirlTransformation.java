package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

// Swirl Transformation
public class SwirlTransformation extends Transformation {

    public SwirlTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public Point apply(Point p) {
        double x = p.x();
        double y = p.y();

        double r = x * x + y * y; // r^2
        double sinR2 = Math.sin(r);
        double cosR2 = Math.cos(r);

        double newX = x * sinR2 - y * cosR2;
        double newY = x * cosR2 + y * sinR2;

        return new Point(newX, newY, red, green, blue);
    }
}

