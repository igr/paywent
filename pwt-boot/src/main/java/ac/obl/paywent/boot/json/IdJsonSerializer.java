package ac.obl.paywent.boot.json;

import ac.obl.paywent.domain.Id;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class IdJsonSerializer extends JsonSerializer<Id<?>> {
    @Override
    public void serialize(final Id value, final JsonGenerator jsonGenerator, final SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(value.toString());
    }
}
