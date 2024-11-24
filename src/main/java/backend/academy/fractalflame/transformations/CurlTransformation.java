package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class CurlTransformation extends Transformation {
    private final double p1;
    private final double p2;

    public CurlTransformation(double p1, double p2, int r, int g, int b) {
        super(r, g, b);
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Point apply(Point p) {
        double t1 = 1 + p1 * p.x() + p2 * (p.x() * p.x() - p.y() * p.y());
        double t2 = p1 * p.y() + 2 * p2 * p.x() * p.y();
        double denom = t1 * t1 + t2 * t2;

        if (denom == 0) {
            return new Point(0, 0, red, green, blue);
        }

        double newX = (p.x() * t1 + p.y() * t2) / denom;
        double newY = (p.y() * t1 - p.x() * t2) / denom;

        return new Point(newX, newY, red, green, blue);
    }
}
