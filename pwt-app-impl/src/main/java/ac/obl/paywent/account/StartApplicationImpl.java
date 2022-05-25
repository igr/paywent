package ac.obl.paywent.account;

import ac.obl.paywent.StartApplication;
import ac.obl.paywent.event.OnPaymentTopic;
import ac.obl.paywent.eventbus.ConnectToEventBus;
import ac.obl.paywent.eventbus.RegisterTopicListener;
import ac.obl.paywent.eventbus.SendMessageToEventBus;
import org.springframework.stereotype.Component;

@Component
public class StartApplicationImpl extends StartApplication {
	public StartApplicationImpl(final ConnectToEventBus connectToEventBus, final SendMessageToEventBus sendMessageToEventBus, final RegisterTopicListener registerTopicListener, final OnPaymentTopic onPaymentTopic) {
		super(connectToEventBus, sendMessageToEventBus, registerTopicListener, onPaymentTopic);
	}
}
