package ac.obl.paywent.domain;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

public interface AccountIdMappers {
	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.CLASS)
	@interface MapAccountIdToUUID {
	}

	@MapAccountIdToUUID
	default UUID mapAccountIdToUUID(final AccountId accountId) {
		return accountId.getId();
	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.CLASS)
	@interface MapUUIDToAccountId {
	}

	@MapUUIDToAccountId
	default AccountId mapUUIDToAccountId(final UUID uuid) {
		return new AccountId(uuid);
	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.CLASS)
	@interface MapAccountIdToString {
	}

	@MapAccountIdToString
	default String mapAccountIdToString(final AccountId accountId) {
		return accountId.toString();
	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.CLASS)
	@interface MapStringToAccountId {
	}

	@MapStringToAccountId
	default AccountId mapStringToAccountId(final String accountId) {
		return new AccountId(accountId);
	}

}
