package ac.obl.paywent.event;

import ac.obl.paywent.domain.PaymentId;
import ac.obl.paywent.payment.MarkPaymentAsProcessed;
import ac.obl.paywent.payment.MarkPaymentAsRejected;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
@Component
@Slf4j
public class OnPaymentTopicImpl implements OnPaymentTopic {

	private final MarkPaymentAsProcessed markPaymentProcessed;
	private final MarkPaymentAsRejected markPaymentAsRejected;

	private final Random rnd = new Random();

	@Override
	public void invoke(final String message) {
		log.debug("Received message: {}", message);

		if (message.equals("READY!")) {
			return;
		}

		final PaymentId paymentId = new PaymentId(message);

		if (rnd.nextDouble() < 0.9d) {
			markPaymentProcessed.invoke(paymentId);
		} else {
			markPaymentAsRejected.invoke(paymentId);
		}
	}
}
