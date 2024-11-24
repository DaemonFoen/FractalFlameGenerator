package backend.academy.fractalflame.config.data;

import backend.academy.fractalflame.transformations.Transformation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("all")
public class JsonConfig implements Config {

    private JsonConfig() {
    }

    private String mode;
    private Integer threads;
    private int samples;
    private int iterations;
    private long seed;
    private World world;
    private Canvas canvas;
    private int symmetry;
    @JsonIgnore
    private List<Transformation> transformations;
    private Output output;
    private double gamma;

    @Override public Mode getMode() {
        return Mode.fromString(mode);
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    @Override public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }

    @Override public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    @Override public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    @Override public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override public int getSymmetry() {
        return symmetry;
    }

    public void setSymmetry(int symmetry) {
        this.symmetry = symmetry;
    }

    @Override public List<Transformation> getTransformations() {
        return transformations;
    }

    @Override
    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @Override public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public void setTransformations(List<Transformation> transformations) {
        this.transformations = transformations;
    }
}
