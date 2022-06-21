package ac.obl.paywent.profile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AddProfileSpecTest {

    AddProfileSpec addProfileSpec;

    @BeforeEach
    void setup() {
        final SetRepo setRepo = new SetRepo();

        final AddProfile addProfile = new AddProfileImpl(setRepo.storeProfile);
        final ListProfiles listProfiles = new ListProfilesImpl(setRepo.fetchProfiles);
        addProfileSpec = new AddProfileSpec(
            addProfile,
            new ProfileNameDoesntExist(listProfiles),
            new ProfileNameExist(listProfiles));
    }

    @Test
    void add_new_profile() {
        assertDoesNotThrow(() -> addProfileSpec.add_new_profile());
    }

}
