package ac.obl.paywent.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileIdTest {

    @Test
    void same_profile_ids_should_be_equals() {
        final ProfileId id1 = new ProfileId("f000aa01-0451-4000-b000-000000000000");
        final ProfileId id2 = new ProfileId("f000aa01-0451-4000-b000-000000000000");

        assertEquals(id1, id2);
    }
}
