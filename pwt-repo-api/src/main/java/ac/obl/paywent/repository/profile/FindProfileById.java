package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.domain.ProfileId;

import java.util.Optional;

@FunctionalInterface
public interface FindProfileById {
    Optional<Profile> invoke(ProfileId profileId);
}
