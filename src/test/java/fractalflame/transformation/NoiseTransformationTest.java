package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.NoiseTransformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoiseTransformationTest {

    @Test
    void testNoiseTransformationRange() {
        NoiseTransformation noiseTransformation = new NoiseTransformation(1234L, 255, 255, 255);
        Point inputPoint = new Point(1.0, 1.0, 0, 0, 0);

        for (int i = 0; i < 100; i++) {
            Point transformedPoint = noiseTransformation.apply(inputPoint);

            assertTrue(Math.abs(transformedPoint.x()) <= 1.0);
            assertTrue(Math.abs(transformedPoint.y()) <= 1.0);
            assertEquals(255, transformedPoint.r());
            assertEquals(255, transformedPoint.g());
            assertEquals(255, transformedPoint.b());
        }
    }

    @Test
    void testNoiseTransformationConsistency() {
        NoiseTransformation noiseTransformation1 = new NoiseTransformation(42L, 255, 255, 255);
        NoiseTransformation noiseTransformation2 = new NoiseTransformation(42L, 211, 211, 211);

        Point inputPoint = new Point(2.0, 3.0, 0, 0, 0);

        Point result1 = noiseTransformation1.apply(inputPoint);
        Point result2 = noiseTransformation2.apply(inputPoint);

        assertEquals(result1.x(), result2.x(), 1e-6 );
        assertEquals(result1.y(), result2.y(), 1e-6 );
    }
}
