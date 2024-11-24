package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.SecantTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecantTransformationTest {

    @Test
    void testSecantTransformation() {
        double v46 = 0.5;
        Transformation transformation = new SecantTransformation(v46, 255, 255, 255);
        Point inputPoint = new Point(1.0, 0.5, 0, 0, 0);
        double radius = Math.sqrt(1.0 + 0.5 * 0.5);
        double expectedX = 1.0;
        double expectedY = 1.0 / Math.cos(v46 * radius);

        Point resultPoint = transformation.apply(inputPoint);

        assertEquals(expectedX, resultPoint.x(), 1e-6);
        assertEquals(expectedY, resultPoint.y(), 1e-6);
        assertEquals(255, resultPoint.r());
        assertEquals(255, resultPoint.g());
        assertEquals(255, resultPoint.b());
    }
}
