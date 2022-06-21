package ac.obl.paywent.profile;

import ac.obl.paywent.domain.ProfileName;
import ac.obl.paywent.repository.profile.FetchProfiles;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class ProfileNameExist implements Predicate<ProfileName> {

    private final FetchProfiles fetchProfiles;

    @Override
    public boolean test(final ProfileName profileName) {
        return fetchProfiles
            .invoke()
            .stream()
            .anyMatch(profile -> profile.getName().get().equals(profileName.get()));
    }
}

