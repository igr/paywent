package ac.obl.paywent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class NewAccount {
	private final String name;
	private final AccountType type;
	private final String number;
}
