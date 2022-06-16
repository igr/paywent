package ac.obl.paywent.profile;

import ac.obl.paywent.domain.ProfileId;
import ac.obl.paywent.domain.ProfilePortfolio;

import java.util.Optional;

@FunctionalInterface
public interface FindProfilePortfolio {
    Optional<ProfilePortfolio> invoke(ProfileId profileId);
}
