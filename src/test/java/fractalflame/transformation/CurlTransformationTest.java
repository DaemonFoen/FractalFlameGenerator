package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.CurlTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CurlTransformationTest {

    @Test
    void testCurlTransformationWithDefaultParams() {
        Transformation curl = new CurlTransformation(1.0, 0.5, 255, 255, 255);
        Point inputPoint = new Point(2.0, 1.0, 100, 150, 200);
        double t1 = 1 + 2.0 + 0.5 * (2.0 * 2.0 - 1.0);
        double t2 = 1.0 + 2 * 0.5 * 2.0 * 1.0;
        double denom = t1 * t1 + t2 * t2;
        double expectedX = (2.0 * t1 + t2) / denom;
        double expectedY = (t1 - 2.0 * t2) / denom;

        Point result = curl.apply(inputPoint);

        assertEquals(expectedX, result.x(), 1e-6);
        assertEquals(expectedY, result.y(), 1e-6);

        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }

    @Test
    void testCurlTransformationWithZeroParams() {
        Transformation curl = new CurlTransformation(0.0, 0.0, 255, 255, 255);
        Point inputPoint = new Point(3.0, 4.0, 1, 1, 1);
        double expectedX = 3.0;
        double expectedY = 4.0;

        Point result = curl.apply(inputPoint);

        assertEquals(expectedX, result.x(), 1e-6);
        assertEquals(expectedY, result.y(), 1e-6);
        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }

    @Test
    void testCurlTransformationHandlesZeroDenominator() {
        Transformation curl = new CurlTransformation(-1.0, 1.0, 255, 255, 255);
        Point inputPoint = new Point(0.0, 0.0, 1, 1, 1);

        Point result = curl.apply(inputPoint);

        assertEquals(0.0, result.x());
        assertEquals(0.0, result.y());

        assertEquals(255, result.r());
        assertEquals(255, result.g());
        assertEquals(255, result.b());
    }
}
