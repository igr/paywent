package ac.obl.paywent.payment;

import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import payment.StorePayment;

@Component
@RequiredArgsConstructor
public class AcceptPaymentImpl implements AcceptPayment {

	private final StorePayment storePayment;

	@Transactional
	@Override
	public Payment invoke(final NewPayment newPayment) {
		return storePayment.invoke(newPayment);
	}
}
