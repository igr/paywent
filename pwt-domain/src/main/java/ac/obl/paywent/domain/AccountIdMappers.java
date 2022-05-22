package ac.obl.paywent.domain;

import org.mapstruct.Named;

import java.util.UUID;

public interface AccountIdMappers {

	String mapAccountIdToUuid = "mapAccountIdToUuid";

	@Named(mapAccountIdToUuid)
	default UUID mapAccountIdToUuid(final AccountId accountId) {
		return accountId.getId();
	}

	String mapUuidToAccountId = "mapUuidToAccountId";

	@Named(mapUuidToAccountId)
	default AccountId mapUuidToAccountId(final UUID uuid) {
		return new AccountId(uuid);
	}

	String mapAccountIdToString = "mapAccountIdToString";

	@Named(mapAccountIdToString)
	default String mapAccountIdToString(final AccountId accountId) {
		return accountId.toString();
	}

}
