package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.Profile;

import java.util.List;

@FunctionalInterface
public interface FetchProfiles {
	List<Profile> invoke();
}
