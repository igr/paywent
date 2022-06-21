package ac.obl.paywent.profile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StoreProfileSpecTest implements Specification {

    StoreProfileSpec storeProfileSpec;

    @BeforeEach
    void setup() {
        final SetRepo setRepo = new SetRepo();
        storeProfileSpec = new StoreProfileSpec(
            setRepo.storeProfile,
            new ProfileNameDoesntExist(setRepo.fetchProfiles),
            new ProfileNameExist(setRepo.fetchProfiles));
    }

    @Test
    void store_profile_saves_new_profile() {
        assertDoesNotThrow(() -> storeProfileSpec.store_profile());
    }

}
