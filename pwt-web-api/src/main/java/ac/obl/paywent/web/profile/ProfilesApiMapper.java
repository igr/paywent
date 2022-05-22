package ac.obl.paywent.web.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.domain.ProfileIdMappers;
import ac.obl.paywent.domain.TimeMappers;
import ac.obl.paywent.web.model.NewProfileRequest;
import ac.obl.paywent.web.model.ProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfilesApiMapper extends ProfileIdMappers, TimeMappers {

	NewProfile mapToNewProfile(NewProfileRequest newProfileRequest);

	@Mapping(source = "id", target = "id", qualifiedByName = mapProfileIdToString)
	ProfileResponse mapToProfileResponse(Profile profile);


}
