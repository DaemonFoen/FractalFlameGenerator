package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class PolarTransformation extends Transformation {

    public PolarTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public Point apply(Point p) {
        double x = p.x();
        double y = p.y();
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        double newX = theta / Math.PI;
        double newY = r - 1;

        return new Point(newX, newY, red, green, blue);
    }
}
