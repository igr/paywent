package ac.obl.paywent;

import ac.obl.paywent.event.OnPaymentTopic;
import ac.obl.paywent.eventbus.ConnectToEventBus;
import ac.obl.paywent.eventbus.EventTopics;
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

	@Override
	public AppRunningContext invoke() {
		connectToEventBus.invoke();

		final TopicListener topicListener = registerTopicListener.invoke(EventTopics.PAYMENT_TOPIC, onPaymentTopic::invoke)
						.start();

		sendMessageToEventBus.invoke(EventTopics.PAYMENT_TOPIC, "READY!");

		return AppRunningContext.builder()
				.topicListener(topicListener)
				.build();
	}

}
