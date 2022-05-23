package ac.obl.paywent.payment;

import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.domain.PaymentId;

import java.util.Optional;

@FunctionalInterface
public interface GetPayment {
	Optional<Payment> invoke(PaymentId paymentId);
}
