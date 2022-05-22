package ac.obl.paywent.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.repository.account.FetchAccounts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ListAccountsImpl implements ListAccounts {
	private final FetchAccounts fetchAccounts;

	@Transactional
	@Override
	public List<Account> invoke() {
		return fetchAccounts.invoke();
	}
}
