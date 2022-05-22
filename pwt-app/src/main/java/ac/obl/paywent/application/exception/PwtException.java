package ac.obl.paywent.application.exception;

/**
 * Root exception for the application.
 */
public class PwtException extends RuntimeException {

    public PwtException(final String message) {
        super(message);
    }

    public PwtException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PwtException(final Throwable cause) {
        super(cause);
    }
}
