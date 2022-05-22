package ac.obl.paywent.domain;

import java.util.UUID;

public class AccountId extends Id.UuidId {
	public AccountId(final UUID id) {
		super(id);
	}

	public AccountId(final String value) {
		super(UUID.fromString(value));
	}
}
