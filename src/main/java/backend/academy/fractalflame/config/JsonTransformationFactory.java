package backend.academy.fractalflame.config;

import backend.academy.fractalflame.exceptions.TransformationFactoryException;
import backend.academy.fractalflame.transformations.CurlTransformation;
import backend.academy.fractalflame.transformations.ExponentialTransformation;
import backend.academy.fractalflame.transformations.HandkerchiefTransformation;
import backend.academy.fractalflame.transformations.HyperbolicTransformation;
import backend.academy.fractalflame.transformations.NoiseTransformation;
import backend.academy.fractalflame.transformations.PerspectiveTransformation;
import backend.academy.fractalflame.transformations.PolarTransformation;
import backend.academy.fractalflame.transformations.SecantTransformation;
import backend.academy.fractalflame.transformations.SinusoidalTransformation;
import backend.academy.fractalflame.transformations.SphericalTransformation;
import backend.academy.fractalflame.transformations.SpiralTransformation;
import backend.academy.fractalflame.transformations.SwirlTransformation;
import backend.academy.fractalflame.transformations.Transformation;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings("all")
public class JsonTransformationFactory {

    private JsonTransformationFactory() {
    }

    public static List<Transformation> createTransformations(JsonNode root) {
        List<Transformation> transformations = new ArrayList<>();

        try {
            JsonNode transformationsNode = root.get("transformations");

            for (JsonNode node : transformationsNode) {
                String type = node.get("type").asText();

                JsonNode rgbNode = node.get("rgb");
                int r = rgbNode.get("r").asInt();
                int g = rgbNode.get("g").asInt();
                int b = rgbNode.get("b").asInt();

                switch (type) {
                    case "CurlTransformation" -> {
                        double c1 = node.get("params").get("c1").asDouble();
                        double c2 = node.get("params").get("c2").asDouble();
                        transformations.add(new CurlTransformation(c1, c2, r, g, b));
                    }

                    case "ExponentialTransformation" -> transformations.add(new ExponentialTransformation(r, g, b));
                    case "HandkerchiefTransformation" -> transformations.add(new HandkerchiefTransformation(r, g, b));
                    case "HyperbolicTransformation" -> transformations.add(new HyperbolicTransformation(r, g, b));
                    case "NoiseTransformation" -> {
                        long seed = node.get("params").get("seed").asLong();
                        transformations.add(new NoiseTransformation(seed, r, g, b));
                    }
                    case "PerspectiveTransformation" -> {
                        double angle = node.get("params").get("angle").asDouble();
                        double dist = node.get("params").get("dist").asDouble();
                        transformations.add(new PerspectiveTransformation(angle, dist, r, g, b));
                    }
                    case "PolarTransformation" -> transformations.add(new PolarTransformation(r, g, b));
                    case "SecantTransformation" -> {
                        double v46 = node.get("params").get("v46").asDouble();
                        transformations.add(new SecantTransformation(v46, r, g, b));
                    }
                    case "SinusoidalTransformation" -> transformations.add(new SinusoidalTransformation(r, g, b));
                    case "SphericalTransformation" -> transformations.add(new SphericalTransformation(r, g, b));
                    case "SpiralTransformation" -> transformations.add(new SpiralTransformation(r, g, b));
                    case "SwirlTransformation" -> transformations.add(new SwirlTransformation(r, g, b));
                    default -> throw new IllegalArgumentException("Unknown transformation type: " + type);
                }
            }
        } catch (Exception e) {
            throw new TransformationFactoryException(e.getMessage(), e.getCause());
        }

        return transformations;
    }
}
