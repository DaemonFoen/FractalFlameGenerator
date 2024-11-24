package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class ExponentialTransformation extends Transformation {

    public ExponentialTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public Point apply(Point p) {
        double factor = Math.exp(p.x() - 1);
        double newX = factor * Math.cos(Math.PI * p.y());
        double newY = factor * Math.sin(Math.PI * p.y());
        return new Point(newX, newY, red, green, blue);
    }
}
