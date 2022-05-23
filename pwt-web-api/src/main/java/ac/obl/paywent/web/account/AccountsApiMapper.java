package ac.obl.paywent.web.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.AccountIdMappers;
import ac.obl.paywent.domain.NewAccount;
import ac.obl.paywent.web.model.AccountResponse;
import ac.obl.paywent.web.model.NewAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountsApiMapper extends AccountIdMappers {

	NewAccount mapToNewAccount(NewAccountRequest newAccountRequest);

	@Mapping(source = "id", target = "id", qualifiedBy = MapAccountIdToString.class)
	AccountResponse mapToAccountResponse(Account account);

}
