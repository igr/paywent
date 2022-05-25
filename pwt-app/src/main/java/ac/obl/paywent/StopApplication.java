package ac.obl.paywent;

@FunctionalInterface
public interface StopApplication {
	void invoke(AppRunningContext appRunningContext);
}
