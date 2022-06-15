package ac.obl.paywent.web.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.AccountIdMappers;
import ac.obl.paywent.domain.NewAccount;
import ac.obl.paywent.domain.ProfileIdMappers;
import ac.obl.paywent.map.PwtMapperConfig;
import ac.obl.paywent.web.model.AccountResponse;
import ac.obl.paywent.web.model.NewAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = PwtMapperConfig.class)
public interface AccountsApiMapper extends AccountIdMappers, ProfileIdMappers {

    @Mapping(target = "profileId", source = "profileId", qualifiedBy = MapStringToProfileId.class)
    NewAccount mapToNewAccount(NewAccountRequest newAccountRequest);

    @Mapping(target = "id", source = "id", qualifiedBy = MapAccountIdToString.class)
    @Mapping(target = "profileId", source = "profileId", qualifiedBy = MapProfileIdToString.class)
    AccountResponse mapToAccountResponse(Account account);

}
