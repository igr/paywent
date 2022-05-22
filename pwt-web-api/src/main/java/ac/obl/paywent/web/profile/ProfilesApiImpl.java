package ac.obl.paywent.web.profile;

import ac.obl.paywent.profile.AddProfile;
import ac.obl.paywent.profile.ListProfiles;
import ac.obl.paywent.web.NotImplementedException;
import ac.obl.paywent.web.ProfilesApi;
import ac.obl.paywent.web.model.NewProfileRequest;
import ac.obl.paywent.web.model.ProfileResponse;
import lombok.RequiredArgsConstructor;
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

	@Override
	public ResponseEntity<Void> _deleteProfileById(final String id) {
		throw new NotImplementedException();
	}

	@Override
	public ResponseEntity<ProfileResponse> _getProfileById(final String id) {
		throw new NotImplementedException();
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
	public ResponseEntity<ProfileResponse> _postProfile(final NewProfileRequest newProfileRequest) {
		final var createdProfile = addProfile.invoke(mapper.mapToNewProfile(newProfileRequest));
		return ResponseEntity.ok(mapper.mapToProfileResponse(createdProfile));
	}
}
