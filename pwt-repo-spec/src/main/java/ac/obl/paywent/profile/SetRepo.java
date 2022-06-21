package ac.obl.paywent.profile;

import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.domain.ProfileName;
import ac.obl.paywent.repository.profile.FetchProfiles;
import ac.obl.paywent.repository.profile.StoreProfile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This is actually an _in-memory_ implementation of the Repo interface.
 * I've put it here only for the simplicity reasons.
 * This should be done in a better way.
 */
public class SetRepo {
    private final Set<Profile> repo = new HashSet<>();
    public final StoreProfile storeProfile = newProfile -> {
        final Profile profile = Profile
            .builder()
            .name(ProfileName.of(newProfile.getName()))
            .createdAt(Instant.now())
            .build();
        repo.add(profile);
        return profile;
    };
    public final FetchProfiles fetchProfiles = () -> new ArrayList<>(repo);
}
