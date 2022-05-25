package ac.obl.paywent.web.payment;

import ac.obl.paywent.domain.PaymentId;
import ac.obl.paywent.domain.PaymentStatus;

@FunctionalInterface
public interface UpdatePaymentStatus {
	void invoke(PaymentId paymentId, PaymentStatus newStatus);
}
