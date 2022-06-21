package ac.obl.paywent.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.ProfileName;
import ac.obl.paywent.repository.profile.StoreProfile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StoreProfileSpec implements Specification {

    private final StoreProfile storeProfile;
    private final ProfileNameDoesntExist profileNameDoesntExist;
    private final ProfileNameExist profileNameExist;

    void store_profile() {
        final ProfileName profileName = ProfileName.of("PROFILE A");

        // given (setup)
        given(profileNameDoesntExist, profileName);

        // when (exercise)
        storeProfile.invoke(NewProfile.builder().name(profileName.get()).build());

        // then (verify)
        then(profileNameExist, profileName);
    }
}
