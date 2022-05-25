package ac.obl.paywent;

import ac.obl.paywent.eventbus.ConnectToEventBus;
import ac.obl.paywent.eventbus.RegisterTopicListener;
import ac.obl.paywent.eventbus.SendMessageToEventBus;
import ac.obl.paywent.eventbus.TopicListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class StartApplication {

	private final ConnectToEventBus connectToEventBus;
	private final SendMessageToEventBus sendMessageToEventBus;
	private final RegisterTopicListener registerTopicListener;

	private TopicListener topicListener;

	// todo return running context
	public void invoke() {
		this.topicListener = registerTopicListener.invoke("payment-topic", message -> {
			log.debug("Received message: {}", message);
		});
		this.topicListener.start();
		connectToEventBus.invoke();
		sendMessageToEventBus.invoke("payment-topic", "READY!");
	}
}
