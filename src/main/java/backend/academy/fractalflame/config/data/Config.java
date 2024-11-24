package backend.academy.fractalflame.config.data;

import backend.academy.fractalflame.transformations.Transformation;
import java.util.List;

public interface Config {

    Mode getMode();

    Integer getThreads();

    int getSamples();

    int getIterations();

    long getSeed();

    World getWorld();

    Canvas getCanvas();

    int getSymmetry();

    List<Transformation> getTransformations();

    Output getOutput();

    double getGamma();

    record Output(String path, String format) {

    }

    record World(
        double x,
        double y,
        double width,
        double height
    ) {

    }

    record Canvas(
        int width,
        int height
    ) {

    }

    enum Mode {
        PARALLEL("parallel"),
        SEQUENTIAL("sequential");

        private final String value;

        Mode(String value) {
            this.value = value;
        }

        public static Mode fromString(String mode) {
            for (Mode m : Mode.values()) {
                if (m.value.equals(mode)) {
                    return m;
                }
            }
            throw new IllegalArgumentException("Unknown mode " + mode);
        }
    }
}
