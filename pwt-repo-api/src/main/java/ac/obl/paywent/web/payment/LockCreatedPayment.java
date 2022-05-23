package ac.obl.paywent.web.payment;

import ac.obl.paywent.domain.Payment;

import java.util.Optional;

@FunctionalInterface
public interface LockCreatedPayment {
	Optional<Payment> invoke();
}
