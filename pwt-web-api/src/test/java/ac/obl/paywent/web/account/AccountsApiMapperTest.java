package ac.obl.paywent.web.account;

import ac.obl.paywent.domain.NewAccount;
import ac.obl.paywent.web.model.NewAccountRequest;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountsApiMapperTest {

    final PodamFactory factory = new PodamFactoryImpl();

    @Test
    void mapToNewAccount() {
        final NewAccountRequest newAccountRequest = factory.manufacturePojo(NewAccountRequest.class);
        newAccountRequest.setProfileId(UUID.randomUUID().toString());
        final NewAccount newAccount = new AccountsApiMapperImpl().mapToNewAccount(newAccountRequest);

        assertEquals(newAccountRequest.getProfileId(), newAccount.getProfileId().getId().toString());
    }
}
