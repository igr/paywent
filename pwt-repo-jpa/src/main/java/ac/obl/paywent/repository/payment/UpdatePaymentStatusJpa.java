package ac.obl.paywent.repository.payment;

import ac.obl.paywent.domain.PaymentId;
import ac.obl.paywent.domain.PaymentStatus;
import ac.obl.paywent.web.payment.UpdatePaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdatePaymentStatusJpa implements UpdatePaymentStatus {
	private final PaymentCrudRepository paymentCrudRepository;

	@Override
	public void invoke(final PaymentId paymentId, final PaymentStatus newStatus) {
		paymentCrudRepository.updatePaymentStatus(paymentId.getId(), newStatus);
	}
}
