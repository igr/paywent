package ac.obl.paywent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class NewAccount {
    private final ProfileId profileId;
    private final String name;
    private final AccountType type;
    private final String number;

    // just meta required for mapstruct
    private final Instant updatedAt = Instant.now();
    private final Instant createdAt = Instant.now();
}
