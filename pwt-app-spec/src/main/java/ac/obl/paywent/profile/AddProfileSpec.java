package ac.obl.paywent.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.ProfileName;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddProfileSpec implements Specification {

    private final AddProfile addProfile;
    private final ProfileNameDoesntExist profileNameDoesntExist;
    private final ProfileNameExist profileNameExist;

    void add_new_profile() {
        final ProfileName profileName = ProfileName.of("PROFILE A");

        // given (setup)
        given(profileNameDoesntExist, profileName);

        // when (exercise)
        addProfile.invoke(NewProfile.builder().name(profileName.get()).build());

        // then (verify)
        then(profileNameExist, profileName);
    }
}
