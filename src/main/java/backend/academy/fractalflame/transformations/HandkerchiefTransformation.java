package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class HandkerchiefTransformation extends Transformation {

    public HandkerchiefTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public Point apply(Point p) {
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double theta = Math.atan2(p.y(), p.x());
        double newX = r * Math.sin(theta + r);
        double newY = r * Math.cos(theta - r);

        return new Point(newX, newY, red, green, blue);
    }
}
