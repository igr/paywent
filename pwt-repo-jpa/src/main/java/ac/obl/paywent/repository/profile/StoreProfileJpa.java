package ac.obl.paywent.repository.profile;

import ac.obl.paywent.domain.NewProfile;
import ac.obl.paywent.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreProfileJpa implements StoreProfile {
    private final ProfileCrudRepository profileCrudRepository;
    private final ProfileEntityMapper mapper;

    @Override
    public Profile invoke(final NewProfile profile) {
        final var profileEntity = mapper.toEntity(profile);
        final var savedEntity = profileCrudRepository.save(profileEntity);
        return mapper.toModel(savedEntity);
    }

}
