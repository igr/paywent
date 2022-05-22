package ac.obl.paywent.web;

import ac.obl.paywent.web.error.ApiError;
import jodd.exception.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Object> handlePropertiesValidationException(final IllegalArgumentException exception, final WebRequest request) {
		return buildErrorResponse(
				new ApiError(HttpStatus.BAD_REQUEST, "Invalid property", exception, request)
		);
	}


	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
		return buildErrorResponse(
				new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", ex, request)
		);
	}

	// ---------------------------------------------------------------- builders

	private ResponseEntity<Object> buildErrorResponse(final ApiError apiError) {
		return buildErrorResponse(apiError, LogLevel.ERROR);
	}

	private ResponseEntity<Object> buildErrorResponse(final ApiError apiError,
	                                                  final LogLevel logLevel) {
		switch (logLevel) {
			case WARN:
				logger.warn(
						apiError.getErrorCode() + " " +
								apiError.getMessage() + " : " +
								ExceptionUtil.message(apiError.getThrowable()), apiError.getThrowable());
			case INFO:
				logger.info(
						apiError.getErrorCode() + " " +
								apiError.getMessage() + " : " +
								ExceptionUtil.message(apiError.getThrowable()), apiError.getThrowable());
			default:
				logger.error(
						apiError.getErrorCode() + " " +
								apiError.getMessage() + " : " +
								ExceptionUtil.message(apiError.getThrowable()), apiError.getThrowable());
		}

		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}
}
