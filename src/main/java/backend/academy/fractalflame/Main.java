package backend.academy.fractalflame;

import backend.academy.fractalflame.config.ConfigLoader;
import backend.academy.fractalflame.config.JsonConfigLoader;
import backend.academy.fractalflame.config.data.Config;
import backend.academy.fractalflame.config.data.Config.Mode;
import backend.academy.fractalflame.domain.FractalImage;
import backend.academy.fractalflame.processing.ConcurrentFractalFlameGenerator;
import backend.academy.fractalflame.processing.FractalFlameGenerator;
import backend.academy.fractalflame.processing.GammaCorrection;
import backend.academy.fractalflame.processing.SequentialFractalFlameGenerator;
import java.io.File;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        ConfigLoader configLoader =
            new JsonConfigLoader(args[0], "src/main/resources/schema.json");

        Config config = configLoader.load();

        FractalImage image;
        if (config.getMode() == Mode.PARALLEL) {
            ConcurrentFractalFlameGenerator generator = new ConcurrentFractalFlameGenerator(config);
            image = generator.render();
        } else {
            FractalFlameGenerator generator = new SequentialFractalFlameGenerator(config);
            image = generator.render();
        }

        GammaCorrection.applyGammaCorrection(image, config.getGamma());
        ImageUtils.save(image, new File(config.getOutput().path()), config.getOutput().format());
    }
}
