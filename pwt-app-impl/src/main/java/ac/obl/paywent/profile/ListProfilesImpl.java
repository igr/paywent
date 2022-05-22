package ac.obl.paywent.profile;

import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.repository.profile.FetchProfiles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListProfilesImpl implements ListProfiles {

	private final FetchProfiles fetchProfiles;

	@Override
	@Transactional
	public List<Profile> invoke() {
		return fetchProfiles.invoke();
	}
}
