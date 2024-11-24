package backend.academy.fractalflame.processing;

import backend.academy.fractalflame.config.data.Config;
import backend.academy.fractalflame.domain.FractalImage;
import backend.academy.fractalflame.domain.FractalImage.Pixel;
import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.transformations.Transformation;
import java.util.Random;
import static backend.academy.fractalflame.processing.ProcessingUtils.randomPoint;
import static backend.academy.fractalflame.processing.ProcessingUtils.rotatePoint;

public class SequentialFractalFlameGenerator extends FractalFlameGenerator {

    public SequentialFractalFlameGenerator(Config config) {
        super(config);
    }

    @Override
    @SuppressWarnings("all")
    public FractalImage render() {
        Random rand = new Random(seed);

        for (int num = 0; num < samples; ++num) {
            Point pw = randomPoint(world, rand);

            for (int step = -20; step < iterPerSample; ++step) {
                Transformation transformation = transformations.get(rand.nextInt(transformations.size()));
                pw = transformation.apply(pw);

                for (int s = 0; s < symmetry; s++) {
                    double theta = Math.PI * 2 * s / symmetry;
                    Point rotatedPoint = rotatePoint(pw, theta);

                    if (world.contains(rotatedPoint)) {
                        int x = (int) ((rotatedPoint.x() - world.x()) / world.width() * canvas.width());
                        int y = (int) ((rotatedPoint.y() - world.y()) / world.height() * canvas.height());

                        if (x >= 0 && x < canvas.width() && y >= 0 && y < canvas.height()) {
                            Pixel pixel = canvas.pixel(x, y);
                            pixel.incrementHitCount();
                            pixel.averageColor(rotatedPoint.r(), rotatedPoint.g(), rotatedPoint.b());
                        }
                    }
                }
            }
        }
        return canvas;
    }
}
