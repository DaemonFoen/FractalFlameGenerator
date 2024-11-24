package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.ExponentialTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExponentialTransformationTest {

    @Test
    void testExponentialTransformation() {
        Transformation exponential = new ExponentialTransformation(255,255,255);
        Point inputPoint = new Point(1.0, 0.5, 100, 150, 200);
        double expectedX = Math.exp(1.0 - 1) * Math.cos(Math.PI * 0.5);
        double expectedY = Math.exp(1.0 - 1) * Math.sin(Math.PI * 0.5);

        Point result = exponential.apply(inputPoint);

        assertEquals(expectedX, result.x(), 1e-6);
        assertEquals(expectedY, result.y(), 1e-6);

        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }
}
