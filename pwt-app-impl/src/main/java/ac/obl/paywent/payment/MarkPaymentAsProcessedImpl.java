package ac.obl.paywent.payment;

import ac.obl.paywent.domain.PaymentId;
import ac.obl.paywent.domain.PaymentStatus;
import ac.obl.paywent.web.payment.UpdatePaymentStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class MarkPaymentAsProcessedImpl implements MarkPaymentAsProcessed {
	private final UpdatePaymentStatus updatePaymentStatus;

	@Transactional
	@Override
	public void invoke(final PaymentId paymentId) {
		log.info("Accept payment {}", paymentId);
		updatePaymentStatus.invoke(paymentId, PaymentStatus.ACCEPTED);
	}
}
