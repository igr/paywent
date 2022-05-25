package ac.obl.paywent.eventbus;

@FunctionalInterface
public interface SendMessageToEventBus {
	void invoke(String topic, String message);
}
