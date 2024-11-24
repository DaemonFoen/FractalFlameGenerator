package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.SwirlTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SwirlTransformationTest {

    @Test
    void testSwirlTransformation() {
        Transformation transformation = new SwirlTransformation(255, 255, 255);

        Point input = new Point(1.0, 1.0, 0, 0, 0);
        double rSquared = 1.0 + 1.0;
        double sinR2 = Math.sin(rSquared);
        double cosR2 = Math.cos(rSquared);
        double expectedX = sinR2 - cosR2;
        double expectedY = cosR2 + sinR2;

        Point result = transformation.apply(input);

        assertEquals(expectedX, result.x(), 1e-6);
        assertEquals(expectedY, result.y(), 1e-6);
        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }

    @Test
    void testSwirlTransformationZeroInput() {
        SwirlTransformation transformation = new SwirlTransformation(255, 255, 255);

        Point input = new Point(0.0, 0.0, 0, 0, 0);
        Point result = transformation.apply(input);

        assertEquals(0.0, result.x(), 1e-6);
        assertEquals(0.0, result.y(), 1e-6);
        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }
}
