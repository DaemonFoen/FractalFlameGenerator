package backend.academy.fractalflame.config;

import backend.academy.fractalflame.exceptions.ValidationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaException;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.io.File;
import java.util.Set;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JsonConfigValidator {

    private final JsonSchema schema;

    public JsonConfigValidator(String schemePath) {
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        schema = schemaFactory.getSchema(new File(schemePath).toURI());
    }

    public void validate(JsonNode configJson) {
        try {
            Set<ValidationMessage> validationErrors = schema.validate(configJson);
            if (!validationErrors.isEmpty()) {
                validationErrors.forEach(log::error);
                throw new JsonSchemaException(String.valueOf(validationErrors));
            }
        } catch (Exception e) {
            throw new ValidationException(e);
        }

    }
}
