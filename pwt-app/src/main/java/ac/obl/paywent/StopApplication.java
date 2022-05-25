package ac.obl.paywent;

/**
 * Stops the application.
 */
@FunctionalInterface
public interface StopApplication {
	void invoke(AppRunningContext appRunningContext);
}
