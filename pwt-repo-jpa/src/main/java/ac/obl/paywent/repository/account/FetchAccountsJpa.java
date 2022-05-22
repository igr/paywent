package ac.obl.paywent.repository.account;


import ac.obl.paywent.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class FetchAccountsJpa implements FetchAccounts {
	private final AccountCrudRepository accountCrudRepository;

	private final AccountEntityMapper mapper;

	@Override
	public List<Account> invoke() {
		return StreamSupport
				.stream(accountCrudRepository.findAll().spliterator(), false)
				.map(mapper::toModel)
				.collect(Collectors.toList());
	}
}
