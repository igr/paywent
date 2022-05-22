package ac.obl.paywent.profile;

import ac.obl.paywent.domain.Profile;

import java.util.List;

@FunctionalInterface
public interface ListProfiles {
	List<Profile> invoke();
}
