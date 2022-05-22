package ac.obl.paywent.web.profile;

import ac.obl.paywent.domain.Profile;
import ac.obl.paywent.profile.AddProfile;
import ac.obl.paywent.web.ProfilesApi;
import ac.obl.paywent.web.model.NewProfileRequest;
import ac.obl.paywent.web.model.ProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProfilesApiImpl implements ProfilesApi {

	private final AddProfile addProfile;
	private final ProfilesApiMapper mapper;

	@Override
	public ResponseEntity<Void> _deleteProfileById(final String id) {
		return null;
	}

	@Override
	public ResponseEntity<ProfileResponse> _getProfileById(final String id) {
		return null;
	}

	@Override
	public ResponseEntity<List<ProfileResponse>> _getProfiles() {
		System.out.println("111");
		return null;
	}

	@Override
	public ResponseEntity<ProfileResponse> _postProfile(final NewProfileRequest newProfileRequest) {
		final Profile createdProfile = addProfile.invoke(mapper.mapToNewProfile(newProfileRequest));
		return ResponseEntity.ok(mapper.mapToProfileResponse(createdProfile));
	}
}
