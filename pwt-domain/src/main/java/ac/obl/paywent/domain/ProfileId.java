package ac.obl.paywent.domain;

import java.util.UUID;

public class ProfileId extends Id.UuidId {
    public ProfileId(final UUID id) {
        super(id);
    }

    public ProfileId(final String value) {
        super(UUID.fromString(value));
    }

}
