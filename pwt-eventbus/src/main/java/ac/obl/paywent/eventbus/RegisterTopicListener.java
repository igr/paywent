package ac.obl.paywent.eventbus;

import java.util.function.Consumer;

@FunctionalInterface
public interface RegisterTopicListener {
	TopicListener invoke(String topic, Consumer<String> listener);
}
