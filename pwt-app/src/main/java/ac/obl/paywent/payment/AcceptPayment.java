package ac.obl.paywent.payment;

import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;

@FunctionalInterface
public interface AcceptPayment {
	Payment invoke(NewPayment newPayment);
}
