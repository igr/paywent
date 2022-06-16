package ac.obl.paywent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class Account {
	private final AccountId id;
	private final AccountType type;
    private final ProfileId profileId;
    private final AccountName name;
    private final String number;
	private final Instant createdAt;
	private final Instant updatedAt;
}

