package ac.obl.paywent.payment;

import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.web.payment.StorePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreatePaymentImpl implements CreatePayment {

	private final StorePayment storePayment;

	@Transactional
	@Override
	public Payment invoke(final NewPayment newPayment) {
		return storePayment.invoke(newPayment);
	}
}
