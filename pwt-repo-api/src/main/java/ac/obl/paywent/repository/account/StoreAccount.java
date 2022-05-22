package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.NewAccount;

@FunctionalInterface
public interface StoreAccount {
	Account invoke(NewAccount newAccount);
}
