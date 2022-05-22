package ac.obl.paywent.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.repository.profile.StoreProfile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddProfileImpl implements AddProfile {

	private final StoreProfile storeProfile;

	@Override
	@Transactional
	public Profile invoke(final NewProfile newProfile) {
		log.info("Adding profile: {}", newProfile);
		return storeProfile.invoke(newProfile);
	}
}
