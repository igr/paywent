package ac.obl.paywent.domain;

import org.mapstruct.Named;

import java.util.UUID;

public interface ProfileIdMappers {

    String mapProfileIdToUuid = "mapProfileIdToUuid";

    @Named(mapProfileIdToUuid)
    default UUID mapProfileIdToUuid(final ProfileId profileId) {
        return profileId.getId();
    }

    String mapUuidToProfileId = "mapUuidToProfileId";

    @Named(mapUuidToProfileId)
    default ProfileId mapUuidToProfileId(final UUID uuid) {
        return new ProfileId(uuid);
    }

    String mapProfileIdToString = "mapProfileIdToString";

    @Named(mapProfileIdToString)
    default String mapProfileIdToString(final ProfileId profileId) {
        return profileId.toString();
    }

}
