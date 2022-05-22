package ac.obl.paywent.web.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {

    private final String object;
    private final String field;
    private final Object rejectedValue;
    private final String message;

}
