package ac.obl.paywent.web.account;

import ac.obl.paywent.account.AddAccount;
import ac.obl.paywent.account.ListAccounts;
import ac.obl.paywent.web.AccountsApi;
import ac.obl.paywent.web.model.AccountResponse;
import ac.obl.paywent.web.model.NewAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AccountsApiImpl implements AccountsApi {

    private final AddAccount addAccount;
    private final ListAccounts listAccounts;

    private final AccountsApiMapper mapper;

    @Override
    public ResponseEntity<List<AccountResponse>> _getAccounts() {
        return ResponseEntity.ok(
            listAccounts.invoke()
                .stream()
                .map(mapper::mapToAccountResponse)
                .collect(Collectors.toList())
        );
    }

	@Override
	public ResponseEntity<AccountResponse> _postAccounts(final NewAccountRequest newAccountRequest) {
		final var newAccount = addAccount.invoke(mapper.mapToNewAccount(newAccountRequest));
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToAccountResponse(newAccount));
	}
}
