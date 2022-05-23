package ac.obl.paywent.domain;

import java.util.UUID;

public class PaymentId extends Id.UuidId {
	public PaymentId(final UUID id) {
		super(id);
	}

	public PaymentId(final String value) {
		super(UUID.fromString(value));
	}
}

