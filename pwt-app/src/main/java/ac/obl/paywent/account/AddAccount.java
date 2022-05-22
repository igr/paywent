package ac.obl.paywent.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.NewAccount;

@FunctionalInterface
public interface AddAccount {
	Account invoke(final NewAccount newAccount);
}
