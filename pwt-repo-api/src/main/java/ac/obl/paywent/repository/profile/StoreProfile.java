package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;

public interface StoreProfile {
	Profile invoke(NewProfile profile);
}
