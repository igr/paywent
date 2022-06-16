package ac.obl.paywent.web.profile;

import ac.obl.paywent.domain.AccountIdMappers;
import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.domain.ProfileIdMappers;
import ac.obl.paywent.domain.ProfilePortfolio;
import ac.obl.paywent.domain.RawTypeMappers;
import ac.obl.paywent.domain.TimeMappers;
import ac.obl.paywent.map.PwtMapperConfig;
import ac.obl.paywent.web.account.AccountResponseMapper;
import ac.obl.paywent.web.model.NewProfileRequest;
import ac.obl.paywent.web.model.ProfilePortfolioResponse;
import ac.obl.paywent.web.model.ProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = PwtMapperConfig.class)
public interface ProfilesApiMapper extends ProfileIdMappers, AccountIdMappers, TimeMappers, RawTypeMappers, AccountResponseMapper {

    NewProfile mapToNewProfile(NewProfileRequest newProfileRequest);

    @Mapping(source = "id", target = "id", qualifiedBy = MapProfileIdToString.class)
    @Mapping(source = "name", target = "name", qualifiedBy = MapRawTypeToString.class)
    ProfileResponse mapToProfileResponse(Profile profile);

    ProfilePortfolioResponse mapToProfilePortfolioResponse(ProfilePortfolio profilePortfolio);

}
