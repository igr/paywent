package ac.obl.paywent.payment;

import ac.obl.paywent.domain.PaymentId;
import ac.obl.paywent.eventbus.SendMessageToEventBus;
import ac.obl.paywent.web.payment.LockCreatedPayment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendAvailablePaymentImpl implements SendAvailablePayment {

	private final LockCreatedPayment lockCreatedPayment;
	private final SendMessageToEventBus sendMessageToEventBus;

	@Transactional
	@Override
	public void invoke() {
		log.info("Sending first available payment");
		final var payment = lockCreatedPayment.invoke();
		if (payment.isEmpty()) {
			log.info("Nothing to send");
			return;
		}

		final PaymentId paymentId = payment.get().getId();
		log.info("Sending payment {}", paymentId);
		sendMessageToEventBus.invoke("payment-topic", paymentId.toString());
	}
}
