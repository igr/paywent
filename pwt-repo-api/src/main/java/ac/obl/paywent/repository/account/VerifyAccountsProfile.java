package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.AccountId;
import ac.obl.paywent.domain.ProfileId;

public interface VerifyAccountsProfile {
    boolean invoke(AccountId accountId, ProfileId profileId);
}
