package ac.obl.paywent;

import ac.obl.paywent.event.OnPaymentTopic;
import ac.obl.paywent.eventbus.ConnectToEventBus;
import ac.obl.paywent.eventbus.RegisterTopicListener;
import ac.obl.paywent.eventbus.SendMessageToEventBus;
import ac.obl.paywent.eventbus.TopicListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@FunctionalInterface
public interface StartApplication {

	AppRunningContext invoke();
}
