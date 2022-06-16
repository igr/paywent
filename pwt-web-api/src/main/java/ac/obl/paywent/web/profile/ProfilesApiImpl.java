package ac.obl.paywent.web.profile;

import ac.obl.paywent.domain.ProfileId;
import ac.obl.paywent.profile.AddProfile;
import ac.obl.paywent.profile.FindProfilePortfolio;
import ac.obl.paywent.profile.ListProfiles;
import ac.obl.paywent.web.ProfilesApi;
import ac.obl.paywent.web.model.NewProfileRequest;
import ac.obl.paywent.web.model.ProfilePortfolioResponse;
import ac.obl.paywent.web.model.ProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProfilesApiImpl implements ProfilesApi {

    private final AddProfile addProfile;
    private final ListProfiles listProfiles;
    private final ProfilesApiMapper mapper;

    private final FindProfilePortfolio findProfilePortfolio;

    @Override
    public ResponseEntity<Void> _deleteProfileId(final String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ResponseEntity<ProfilePortfolioResponse> _getProfileId(final String id) {
        return ResponseEntity.of(
            findProfilePortfolio
                .invoke(new ProfileId(id))
                .map(mapper::mapToProfilePortfolioResponse)
        );
    }

    @Override
    public ResponseEntity<List<ProfileResponse>> _getProfiles() {
        return ResponseEntity.ok(
            listProfiles.invoke()
                .stream()
                .map(mapper::mapToProfileResponse)
                .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<ProfileResponse> _postProfiles(final NewProfileRequest newProfileRequest) {
        final var createdProfile = addProfile.invoke(mapper.mapToNewProfile(newProfileRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToProfileResponse(createdProfile));
    }
}
