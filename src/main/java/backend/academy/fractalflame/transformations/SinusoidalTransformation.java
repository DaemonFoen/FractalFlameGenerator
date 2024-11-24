package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class SinusoidalTransformation extends Transformation {

    public SinusoidalTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public Point apply(Point p) {
        double newX = Math.sin(p.x()) - Math.cos(p.y());
        double newY = Math.cos(p.x()) + Math.sin(p.y());
        return new Point(newX, newY, red, green, blue);
    }
}
