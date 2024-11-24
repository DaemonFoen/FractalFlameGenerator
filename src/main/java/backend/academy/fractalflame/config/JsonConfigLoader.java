package backend.academy.fractalflame.config;

import backend.academy.fractalflame.config.data.Config;
import backend.academy.fractalflame.config.data.JsonConfig;
import backend.academy.fractalflame.exceptions.ConfigLoadException;
import backend.academy.fractalflame.transformations.Transformation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonConfigLoader implements ConfigLoader {

    private final String configPath;

    private final JsonConfigValidator validator;

    public JsonConfigLoader(String configPath, String schemePath) {
        this.configPath = configPath;
        this.validator = new JsonConfigValidator(schemePath);
    }

    @Override
    public Config load() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode configJson = objectMapper.readTree(new File(configPath));
            validator.validate(configJson);

            JsonConfig renderConfig = objectMapper.readValue(new File(configPath), JsonConfig.class);
            List<Transformation> transformations = JsonTransformationFactory.createTransformations(configJson);
            renderConfig.setTransformations(transformations);

            return renderConfig;
        } catch (IOException e) {
            throw new ConfigLoadException(e);
        }
    }
}
