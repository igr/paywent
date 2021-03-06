package ac.obl.paywent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class Payment {
	private final PaymentId id;
	private final String amount;
	private final String currency;
	private final ProfileId originator;
	private final ProfileId beneficiary;
	private final AccountId sender;
	private final AccountId receiver;
	private final PaymentStatus status;
	private final Instant updatedAt;
	private final Instant createdAt;
}
