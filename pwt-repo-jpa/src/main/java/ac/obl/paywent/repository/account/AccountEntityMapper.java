package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.AccountIdMappers;
import ac.obl.paywent.domain.AccountNameMappers;
import ac.obl.paywent.domain.NewAccount;
import ac.obl.paywent.domain.ProfileIdMappers;
import ac.obl.paywent.domain.RawTypeMappers;
import ac.obl.paywent.map.PwtMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = PwtMapperConfig.class)
public interface AccountEntityMapper extends AccountIdMappers, ProfileIdMappers, RawTypeMappers, AccountNameMappers {

    @Mapping(target = "id", source = "id", qualifiedBy = MapAccountIdToUUID.class)
    @Mapping(target = "profileId", source = "profileId", qualifiedBy = MapProfileIdToUUID.class)
    @Mapping(target = "name", source = "name", qualifiedBy = MapRawTypeToString.class)
    AccountEntity toEntity(Account account);

    @Mapping(target = "id", source = "id", qualifiedBy = MapUUIDToAccountId.class)
    @Mapping(target = "profileId", source = "profileId", qualifiedBy = MapUUIDToProfileId.class)
    @Mapping(target = "name", source = "name", qualifiedBy = MapStringToAccountName.class)
    Account toModel(AccountEntity accountEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profileId", source = "profileId", qualifiedBy = MapProfileIdToUUID.class)
    AccountEntity toEntity(final NewAccount newAccount);

}
