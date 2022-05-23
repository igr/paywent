package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.domain.ProfileIdMappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ProfileEntityMapper extends ProfileIdMappers {

    @Mapping(target = "id", source = "id", qualifiedBy = MapProfileIdToUUID.class)
    ProfileEntity toEntity(Profile profile);

    @Mapping(target = "id", source = "id", qualifiedBy = MapUUIDToProfileId.class)
    Profile toModel(ProfileEntity profileEntity);

    default ProfileEntity toEntity(final NewProfile newProfile) {
        return ProfileEntity.builder()
                .name(newProfile.getName())
                .createdAt(Instant.now())
                .build();
    }
}
