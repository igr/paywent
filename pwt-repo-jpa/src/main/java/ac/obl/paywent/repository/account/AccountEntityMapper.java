package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.AccountIdMappers;
import ac.obl.paywent.domain.NewAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper extends AccountIdMappers {

	@Mapping(target = "id", source = "id", qualifiedByName = mapAccountIdToUuid)
	AccountEntity toEntity(Account account);

	@Mapping(target = "id", source = "id", qualifiedByName = mapUuidToAccountId)
	Account toModel(AccountEntity accountEntity);

	default AccountEntity toEntity(final NewAccount newAccount) {
		return AccountEntity.builder()
				.name(newAccount.getName())
				.number(newAccount.getNumber())
				.type(newAccount.getType())
				.updatedAt(Instant.now())
				.createdAt(Instant.now())
				.build();
	}
}
