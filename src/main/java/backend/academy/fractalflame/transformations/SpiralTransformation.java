package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;

public class SpiralTransformation extends Transformation {

    public SpiralTransformation(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public Point apply(Point p) {
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y()); // Радиус
        double theta = Math.atan2(p.y(), p.x()); // Угол

        if (r == 0) { // Предотвращаем деление на ноль
            return new Point(0, 0, red, green, blue);
        }

        double factor = 1 / r; // 1 / r
        double newX = factor * (Math.cos(theta) + Math.sin(r));
        double newY = factor * (Math.sin(theta) - Math.cos(r));
        return new Point(newX, newY, red, green, blue);
    }
}
