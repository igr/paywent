package ac.obl.paywent.repository.account;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountCrudRepository extends CrudRepository<AccountEntity, UUID> {

    int countAccountEntitiesByIdAndProfileId(UUID id, UUID profileId);
}
