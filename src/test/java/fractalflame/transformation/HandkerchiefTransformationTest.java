package fractalflame.transformation;

import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.HandkerchiefTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandkerchiefTransformationTest {

    @Test
    void testHandkerchiefTransformation() {
        Transformation transformation = new HandkerchiefTransformation(255, 255, 255);
        Point inputPoint = new Point(1.0, 1.0, 0, 0, 0);
        double expectedR = Math.sqrt(1.0 + 1.0);
        double expectedTheta = Math.atan2(1.0, 1.0);
        double expectedX = expectedR * Math.sin(expectedTheta + expectedR);
        double expectedY = expectedR * Math.cos(expectedTheta - expectedR);

        Point resultPoint = transformation.apply(inputPoint);

        assertEquals(expectedX, resultPoint.x(), 1e-6 );
        assertEquals(expectedY, resultPoint.y(), 1e-6 );

        assertEquals(255, resultPoint.r() );
        assertEquals(255, resultPoint.g() );
        assertEquals(255, resultPoint.b() );
    }
}
