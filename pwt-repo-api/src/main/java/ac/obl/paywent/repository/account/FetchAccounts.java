package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.Account;

import java.util.List;

@FunctionalInterface
public interface FetchAccounts {
	List<Account> invoke();
}
