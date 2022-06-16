package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.Account;
import ac.obl.paywent.domain.ProfileId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindProfileAccountsJpa implements FindProfileAccounts {
    private final AccountCrudRepository repository;
    private final AccountEntityMapper mapper;

    @Override
    public List<Account> invoke(final ProfileId profileId) {
        return repository
            .findAccountEntitiesByProfileId(profileId.getId())
            .stream()
            .map(mapper::toModel)
            .collect(Collectors.toList());
    }
}
