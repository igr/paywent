package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.NewAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreAccountJpa implements StoreAccount {

	private final AccountCrudRepository accountCrudRepository;

	private final AccountEntityMapper mapper;

	@Override
	public Account invoke(final NewAccount newAccount) {
		final var accountEntity = mapper.toEntity(newAccount);
		final var savedEntity = accountCrudRepository.save(accountEntity);
		return mapper.toModel(savedEntity);
	}
}
