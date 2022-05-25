package ac.obl.paywent;

import ac.obl.paywent.event.OnPaymentTopic;
import ac.obl.paywent.eventbus.ConnectToEventBus;
import ac.obl.paywent.eventbus.RegisterTopicListener;
import ac.obl.paywent.eventbus.SendMessageToEventBus;
import ac.obl.paywent.eventbus.TopicListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartApplicationImpl implements StartApplication {

	private final ConnectToEventBus connectToEventBus;
	private final SendMessageToEventBus sendMessageToEventBus;
	private final RegisterTopicListener registerTopicListener;
	private final OnPaymentTopic onPaymentTopic;

	public AppRunningContext invoke() {
		connectToEventBus.invoke();

		TopicListener topicListener = registerTopicListener.invoke("payment-topic", onPaymentTopic::invoke);
		topicListener.start();

		sendMessageToEventBus.invoke("payment-topic", "READY!");

		return AppRunningContext.builder()
				.topicListener(topicListener)
				.build();
	}

}
