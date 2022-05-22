package ac.obl.paywent.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.NewAccount;
import ac.obl.paywent.repository.account.StoreAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddAccountImpl implements AddAccount {

	private final StoreAccount storeAccount;

	@Transactional
	@Override
	public Account invoke(final NewAccount newAccount) {
		return storeAccount.invoke(newAccount);
	}
}
