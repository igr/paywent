package ac.obl.paywent.payment;

import ac.obl.paywent.domain.PaymentId;

@FunctionalInterface
public interface MarkPaymentAsProcessed {
	void invoke(PaymentId paymentId);
}
