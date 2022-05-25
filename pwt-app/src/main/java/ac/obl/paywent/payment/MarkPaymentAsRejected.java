package ac.obl.paywent.payment;

import ac.obl.paywent.domain.PaymentId;

@FunctionalInterface
public interface MarkPaymentAsRejected {
	void invoke(PaymentId paymentId);
}
