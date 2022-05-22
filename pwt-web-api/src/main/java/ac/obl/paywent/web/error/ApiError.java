package ac.obl.paywent.web.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jodd.util.RandomString;
import lombok.Data;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Data
public class ApiError {

    @JsonIgnore
    private final Throwable throwable;
    @JsonIgnore
    private final HttpStatus httpStatus;
    private final int status;
    private final String error;
    private final long timestamp;
    private final String message;
    private final String exception;
    private final String errorCode;
    private final String trace;
    private final String path;
    private List<ApiSubError> subErrors;

    public ApiError(final HttpStatus httpStatus, final String message, final Throwable ex,
        final WebRequest request) {
        this.timestamp = System.currentTimeMillis();
        this.errorCode = "ERR-" + RandomString.get().randomAlphaNumeric(16).toUpperCase();
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
        this.exception = ex.getClass().getName();
        this.trace = ExceptionUtils.getStackTrace(ex);
        this.path = request.toString();
        this.throwable = ex;
    }

    public ApiError withSubErrors(final List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
        return this;
    }
}
