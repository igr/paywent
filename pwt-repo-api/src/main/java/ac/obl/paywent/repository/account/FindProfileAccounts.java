package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.ProfileId;

import java.util.List;

@FunctionalInterface
public interface FindProfileAccounts {
    List<Account> invoke(ProfileId profileId);
}
