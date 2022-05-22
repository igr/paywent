package ac.obl.paywent.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;

@FunctionalInterface
public interface AddProfile {
	Profile invoke(final NewProfile newProfile);
}
