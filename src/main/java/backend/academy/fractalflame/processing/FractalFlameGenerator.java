package backend.academy.fractalflame.processing;

import backend.academy.fractalflame.config.data.Config;
import backend.academy.fractalflame.domain.FractalImage;
import backend.academy.fractalflame.domain.Rect;
import backend.academy.fractalflame.transformations.Transformation;
import java.util.List;

public abstract class FractalFlameGenerator {

    protected final Rect world;

    protected final FractalImage canvas;

    protected final List<Transformation> transformations;

    protected final int samples;

    protected final int iterPerSample;

    protected final long seed;

    protected final int symmetry;

    protected FractalFlameGenerator(Config config) {
        world = new Rect(config.getWorld().x(), config.getWorld().y(), config.getWorld().width(),
            config.getWorld().height());
        canvas = FractalImage.create(config.getCanvas().width(), config.getCanvas().height());
        transformations = config.getTransformations();
        samples =  config.getSamples();
        iterPerSample = config.getIterations();
        seed = config.getSeed();
        symmetry = config.getSymmetry();
    }

    public abstract FractalImage render();

}
