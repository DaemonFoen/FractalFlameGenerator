package backend.academy.fractalflame.processing;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.domain.Rect;
import java.util.Random;

class ProcessingUtils {

    private ProcessingUtils() {}

    public static Point rotatePoint(Point p, double theta) {
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        double newX = p.x() * cosTheta - p.y() * sinTheta;
        double newY = p.x() * sinTheta + p.y() * cosTheta;
        return new Point(newX, newY, p.r(), p.g(), p.b());
    }

    public static Point randomPoint(Rect world, Random rand) {
        double x = world.x() + rand.nextDouble() * world.width();
        double y = world.y() + rand.nextDouble() * world.height();
        return new Point(x, y, 0, 0, 0);
    }
}
