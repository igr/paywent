package ac.obl.paywent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class Profile {
    private final ProfileId id;
    private final String name;
    private final Instant createdAt;
}
