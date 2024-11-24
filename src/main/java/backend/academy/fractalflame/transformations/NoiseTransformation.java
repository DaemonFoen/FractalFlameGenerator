package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;
import java.util.Random;

public class NoiseTransformation extends Transformation {
    private final Random random;

    public NoiseTransformation(long seed, int r, int g, int b) {
        super(r, g, b);
        this.random = new Random(seed);
    }

    @Override
    public Point apply(Point p) {
        double psi1 = random.nextDouble();
        double psi2 = random.nextDouble();
        double newX = psi1 * p.x() * Math.cos(2 * Math.PI * psi2);
        double newY = psi1 * p.y() * Math.sin(2 * Math.PI * psi2);

        return new Point(newX, newY, red, green, blue);
    }
}
