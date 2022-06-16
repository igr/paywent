package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.domain.ProfileIdMappers;
import ac.obl.paywent.domain.ProfileNameMappers;
import ac.obl.paywent.domain.RawTypeMappers;
import ac.obl.paywent.map.PwtMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(config = PwtMapperConfig.class)
public interface ProfileEntityMapper extends ProfileIdMappers, RawTypeMappers, ProfileNameMappers {

    @Mapping(target = "id", source = "id", qualifiedBy = MapProfileIdToUUID.class)
    @Mapping(target = "name", source = "name", qualifiedBy = MapRawTypeToString.class)
    ProfileEntity toEntity(Profile profile);

    @Mapping(target = "id", source = "id", qualifiedBy = MapUUIDToProfileId.class)
    @Mapping(target = "name", source = "name", qualifiedBy = MapStringToProfileName.class)
    Profile toModel(ProfileEntity profileEntity);

    default ProfileEntity toEntity(final NewProfile newProfile) {
        return ProfileEntity.builder()
                .name(newProfile.getName())
                .createdAt(Instant.now())
                .build();
    }
}
