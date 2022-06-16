package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.domain.ProfileId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindProfileByIdJpa implements FindProfileById {
    private final ProfileCrudRepository repository;
    private final ProfileEntityMapper mapper;

    @Override
    public Optional<Profile> invoke(final ProfileId profileId) {
        return repository.findById(profileId.getId()).map(mapper::toModel);
    }
}
