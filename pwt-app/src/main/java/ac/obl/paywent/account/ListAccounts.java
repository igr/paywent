package ac.obl.paywent.account;

import ac.obl.paywent.domain.Account;

import java.util.List;

@FunctionalInterface
public interface ListAccounts {
	List<Account> invoke();
}
