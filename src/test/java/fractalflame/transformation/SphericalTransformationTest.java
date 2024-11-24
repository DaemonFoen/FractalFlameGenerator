package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.SphericalTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SphericalTransformationTest {

    @Test
    void testSphericalTransformation() {
        Transformation transformation = new SphericalTransformation(255, 255, 255);

        Point input = new Point(2.0, 1.0, 0, 0, 0);
        double r2 = 2.0 * 2.0 + 1.0;
        double expectedX = 2.0 / r2;
        double expectedY = 1.0 / r2;

        Point result = transformation.apply(input);

        assertEquals(expectedX, result.x(), 1e-6);
        assertEquals(expectedY, result.y(), 1e-6);
        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }

    @Test
    void testSphericalTransformationZeroInput() {
        SphericalTransformation transformation = new SphericalTransformation(255, 255, 255);

        Point input = new Point(0.0, 0.0, 0, 0, 0);
        Point result = transformation.apply(input);

        assertTrue(Double.isFinite(result.x()));
        assertTrue(Double.isFinite(result.y()));
        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }
}
