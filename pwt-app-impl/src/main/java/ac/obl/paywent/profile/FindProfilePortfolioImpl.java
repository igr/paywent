package ac.obl.paywent.profile;

import ac.obl.paywent.domain.ProfileId;
import ac.obl.paywent.domain.ProfilePortfolio;
import ac.obl.paywent.repository.account.FindProfileAccounts;
import ac.obl.paywent.repository.profile.FindProfileById;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindProfilePortfolioImpl implements FindProfilePortfolio {
    private final FindProfileById findProfileById;
    private final FindProfileAccounts findProfileAccounts;

    @Override
    @Transactional
    public Optional<ProfilePortfolio> invoke(final ProfileId profileId) {
        return findProfileById
            .invoke(profileId)
            .map(profile -> ProfilePortfolio.builder()
                .profile(profile)
                .accounts(findProfileAccounts.invoke(profileId))
                .build());
    }
}
