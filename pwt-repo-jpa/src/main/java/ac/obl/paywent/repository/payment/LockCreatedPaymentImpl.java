package ac.obl.paywent.repository.payment;

import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.web.payment.LockCreatedPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LockCreatedPaymentImpl implements LockCreatedPayment {

	private final PaymentCrudRepository paymentCrudRepository;
	private final PaymentEntityMapper mapper;

	@Override
	public Optional<Payment> invoke() {
		return paymentCrudRepository
				.selectCreatedPayments(1)
				.stream()
				.findFirst()
				.map(mapper::toModel);
	}
}
