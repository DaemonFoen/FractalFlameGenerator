package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class HyperbolicTransformation extends Transformation {

    public HyperbolicTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    @SuppressWarnings("all")
    public Point apply(Point p) {
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double theta = Math.atan2(p.y(), p.x());

        if (r == 0) {
            return new Point(0, 0, red, green, blue);
        }

        double newX = Math.sin(theta) / r;
        double newY = r * Math.cos(theta);
        return new Point(newX, newY, red, green, blue);
    }
}
