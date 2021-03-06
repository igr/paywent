package ac.obl.paywent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class NewPayment {
	private final String amount;
	private final String currency;
	private final ProfileId originator;
	private final ProfileId beneficiary;
	private final AccountId sender;
	private final AccountId receiver;
}
