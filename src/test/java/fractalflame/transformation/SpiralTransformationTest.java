package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.SpiralTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralTransformationTest {

    @Test
    void testSpiralTransformation() {
        Transformation transformation = new SpiralTransformation(255, 255, 255);

        Point input = new Point(1.0, 1.0, 0, 0, 0);
        double radius = Math.sqrt(1.0 + 1.0);
        double theta = Math.atan2(1.0, 1.0);
        double factor = 1 / radius;
        double expectedX = factor * (Math.cos(theta) + Math.sin(radius));
        double expectedY = factor * (Math.sin(theta) - Math.cos(radius));

        Point result = transformation.apply(input);

        assertEquals(expectedX, result.x(), 1e-6);
        assertEquals(expectedY, result.y(), 1e-6);
        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }

    @Test
    void testSpiralTransformationZeroRadius() {
        SpiralTransformation transformation = new SpiralTransformation(255, 255, 255);

        Point input = new Point(0.0, 0.0, 0, 0, 0);
        Point result = transformation.apply(input);

        assertEquals(0.0, result.x(), 1e-6);
        assertEquals(0.0, result.y(), 1e-6 );
        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }
}
