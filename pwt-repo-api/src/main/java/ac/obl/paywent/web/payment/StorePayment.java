package ac.obl.paywent.web.payment;

import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;

@FunctionalInterface
public interface StorePayment {
	Payment invoke(NewPayment newPayment);
}
