package ac.obl.paywent.repository.payment;

import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.web.payment.StorePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class StorePaymentJpa implements StorePayment {

	private final PaymentCrudRepository paymentCrudRepository;
	private final PaymentEntityMapper mapper;

	@Override
	public Payment invoke(final NewPayment newPayment) {
		final var paymentEntity = mapper.toEntity(newPayment);
		final var savedEntity = paymentCrudRepository.save(paymentEntity);
		return mapper.toModel(savedEntity);
	}
}
