package backend.academy.fractalflame.transformations;

import backend.academy.fractalflame.domain.Point;
import java.util.function.Function;

public abstract class Transformation implements Function<Point, Point> {
    protected int red;
    protected int green;
    protected int blue;

    Transformation(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }
}
