package ac.obl.paywent;

import ac.obl.paywent.event.OnPaymentTopic;
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
	private final OnPaymentTopic onPaymentTopic;

	private TopicListener topicListener;

	// todo return running context
	public void invoke() {
		this.topicListener = registerTopicListener.invoke("payment-topic", onPaymentTopic::invoke);
		this.topicListener.start();
		connectToEventBus.invoke();
		sendMessageToEventBus.invoke("payment-topic", "READY!");
	}
}
