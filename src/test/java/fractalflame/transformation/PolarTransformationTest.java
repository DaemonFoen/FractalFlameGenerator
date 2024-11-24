package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.PolarTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolarTransformationTest {

    @Test
    void testPolarTransformation() {
        Transformation transformation = new PolarTransformation(255, 255, 255);

        Point inputPoint = new Point(1.0, 0.0, 0, 0, 0);
        double radius = Math.sqrt(1.0 + 0.0 * 0.0);
        double theta = Math.atan2(0.0, 1.0);
        double expectedX = theta / Math.PI;
        double expectedY = radius - 1;

        Point resultPoint = transformation.apply(inputPoint);

        assertEquals(expectedX, resultPoint.x(), 1e-6);
        assertEquals(expectedY, resultPoint.y(), 1e-6);
        assertEquals(255, resultPoint.r());
        assertEquals(255, resultPoint.g());
        assertEquals(255, resultPoint.b());
    }
}
