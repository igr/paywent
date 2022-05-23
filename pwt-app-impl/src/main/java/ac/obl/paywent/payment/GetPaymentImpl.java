package ac.obl.paywent.payment;

import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.domain.PaymentId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetPaymentImpl implements GetPayment {
	@Override
	public Optional<Payment> invoke(final PaymentId paymentId) {
		return Optional.empty();
	}
}
