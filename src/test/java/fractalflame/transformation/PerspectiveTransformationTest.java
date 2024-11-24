package fractalflame.transformation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.PerspectiveTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PerspectiveTransformationTest {

    @Test
    void testPerspectiveTransformation() {
        double angle = Math.PI / 4;
        double dist = 2.0;
        Transformation perspective = new PerspectiveTransformation(angle, dist,255,255,255);

        Point p1 = new Point(1, 1, 0, 0, 0);
        Point p2 = new Point(-1, -1, 0, 0, 0);
        Point p3 = new Point(0, 0, 0, 0, 0);
        Point p4 = new Point(0.5, 0.5, 0, 0, 0);

        Point result1 = perspective.apply(p1);
        Point result2 = perspective.apply(p2);
        Point result3 = perspective.apply(p3);
        Point result4 = perspective.apply(p4);

        double sinP1 = Math.sin(angle);
        double cosP1 = Math.cos(angle);

        double denominator1 = dist - p1.y() * sinP1;
        double factor1 = dist / denominator1;
        assertEquals(factor1 * p1.x(), result1.x(), 1e-6);
        assertEquals(factor1 * (p1.y() * cosP1), result1.y(), 1e-6);
        assertEquals(255, result1.r());
        assertEquals(255, result1.g());
        assertEquals(255, result1.b());

        double denominator2 = dist - p2.y() * sinP1;
        double factor2 = dist / denominator2;
        assertEquals(factor2 * p2.x(), result2.x(), 1e-6);
        assertEquals(factor2 * (p2.y() * cosP1), result2.y(), 1e-6);
        assertEquals(255, result2.r());
        assertEquals(255, result2.g());
        assertEquals(255, result2.b());

        assertEquals(0.0, result3.x(), 1e-6);
        assertEquals(0.0, result3.y(), 1e-6);
        assertEquals(255, result3.r());
        assertEquals(255, result3.g());
        assertEquals(255, result3.b());

        double denominator4 = dist - p4.y() * sinP1;
        double factor4 = dist / denominator4;
        assertEquals(factor4 * p4.x(), result4.x(), 1e-6);
        assertEquals(factor4 * (p4.y() * cosP1), result4.y(), 1e-6);
        assertEquals(255, result4.r());
        assertEquals(255, result4.g());
        assertEquals(255, result4.b());
    }
}
