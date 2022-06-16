package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.AccountId;
import ac.obl.paywent.domain.ProfileId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerifyAccountsProfileJpa implements VerifyAccountsProfile {
    private final AccountCrudRepository accountCrudRepository;

    @Override
    public boolean invoke(final AccountId accountId, final ProfileId profileId) {
        return accountCrudRepository.countAccountEntitiesByIdAndProfileId(accountId.getId(), profileId.getId()) == 1;
    }
}
