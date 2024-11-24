package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.SinusoidalTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SinusoidalTransformationTest {

    @Test
    void testSinusoidalTransformation() {
        Transformation transformation = new SinusoidalTransformation(255, 255, 255);

        Point inputPoint = new Point(Math.PI / 2, Math.PI / 4, 0, 0, 0);
        double expectedX = Math.sin(Math.PI / 2) - Math.cos(Math.PI / 4);
        double expectedY = Math.cos(Math.PI / 2) + Math.sin(Math.PI / 4);

        Point resultPoint = transformation.apply(inputPoint);

        assertEquals(expectedX, resultPoint.x(), 1e-6);
        assertEquals(expectedY, resultPoint.y(), 1e-6);
        assertEquals(255, resultPoint.r());
        assertEquals(255, resultPoint.g());
        assertEquals(255, resultPoint.b());
    }
}
