package backend.academy.fractalflame.processing;

import backend.academy.fractalflame.config.data.Config;
import backend.academy.fractalflame.domain.FractalImage;
import backend.academy.fractalflame.domain.FractalImage.Pixel;
import backend.academy.fractalflame.domain.Point;
import backend.academy.fractalflame.exceptions.AwaitException;
import backend.academy.fractalflame.transformations.Transformation;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static backend.academy.fractalflame.processing.ProcessingUtils.randomPoint;
import static backend.academy.fractalflame.processing.ProcessingUtils.rotatePoint;

public class ConcurrentFractalFlameGenerator extends FractalFlameGenerator {

    private final int threadCount;

    public ConcurrentFractalFlameGenerator(Config config) {
        super(config);
        threadCount = config.getThreads();
    }

    @Override
    @SuppressWarnings("all")
    public FractalImage render() {
        try (ExecutorService executor = Executors.newFixedThreadPool(threadCount)) {

            int pointsPerThread = samples / threadCount;
            for (int t = 0; t < threadCount; t++) {
                int start = t * pointsPerThread;
                int end = (t == threadCount - 1) ? samples : start + pointsPerThread;

                executor.submit(
                    () -> processPoints(start, end));
            }

            executor.shutdown();
            try {
                if (!executor.awaitTermination(365, TimeUnit.DAYS)) {
                    throw new AwaitException("Timeout: some tasks did not finish in the expected time.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return canvas;
        }
    }

    @SuppressWarnings("all")
    private void processPoints(
        int start,
        int end
    ) {
        Random rand = new Random(seed);

        for (int num = start; num < end; ++num) {
            Point pw = randomPoint(world, rand);

            for (int step = -20; step < iterPerSample; ++step) {
                Transformation transformation = transformations.get(rand.nextInt(transformations.size()));
                pw = transformation.apply(pw);

                for (int s = 0; s < symmetry; s++) {
                    double theta = Math.PI * 2 * s / symmetry;
                    Point rotatedPoint = rotatePoint(pw, theta);

                    if (world.contains(rotatedPoint)) {
                        processPixels(rotatedPoint);
                    }
                }
            }
        }
    }

    private void processPixels(Point rotatedPoint) {
        int x = (int) ((rotatedPoint.x() - world.x()) / world.width() * canvas.width());
        int y = (int) ((rotatedPoint.y() - world.y()) / world.height() * canvas.height());

        if (x >= 0 && x < canvas.width() && y >= 0 && y < canvas.height()) {
            synchronized (canvas.pixel(x, y)) {
                Pixel pixel = canvas.pixel(x, y);
                pixel.averageColor(rotatedPoint.r(), rotatedPoint.g(), rotatedPoint.b());
                pixel.incrementHitCount();
            }
        }
    }
}
