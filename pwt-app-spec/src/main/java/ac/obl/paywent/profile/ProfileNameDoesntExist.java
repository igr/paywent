package ac.obl.paywent.profile;

import ac.obl.paywent.domain.ProfileName;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class ProfileNameDoesntExist implements Predicate<ProfileName> {

    private final ListProfiles listProfiles;

    @Override
    public boolean test(final ProfileName profileName) {
        return listProfiles
            .invoke()
            .stream()
            .noneMatch(profile -> profile.getName().get().equals(profileName.get()));
    }
}
