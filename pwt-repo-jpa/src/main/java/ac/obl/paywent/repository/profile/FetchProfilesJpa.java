package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class FetchProfilesJpa implements FetchProfiles {
	private final ProfileCrudRepository profileCrudRepository;
	private final ProfileEntityMapper mapper;

	@Override
	public List<Profile> invoke() {
		return StreamSupport
				.stream(profileCrudRepository.findAll().spliterator(), false)
				.map(mapper::toModel)
				.collect(Collectors.toList());
	}
}
