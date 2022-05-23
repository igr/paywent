package ac.obl.paywent.domain;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

public interface ProfileIdMappers {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapProfileIdToUUID {
    }

    @MapProfileIdToUUID
    default UUID mapProfileIdToUUID(final ProfileId profileId) {
        return profileId.getId();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapUUIDToProfileId {
    }

    @MapUUIDToProfileId
    default ProfileId mapUUIDToProfileId(final UUID uuid) {
        return new ProfileId(uuid);
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapProfileIdToString {
    }

    @MapProfileIdToString
    default String mapProfileIdToString(final ProfileId profileId) {
        return profileId.toString();
    }


    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapStringToProfileId {
    }

    @MapStringToProfileId
    default ProfileId mapStringToProfileId(final String profileId) {
        return new ProfileId(profileId);
    }

}
