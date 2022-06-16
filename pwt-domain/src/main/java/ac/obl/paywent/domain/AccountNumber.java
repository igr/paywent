package ac.obl.paywent.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountNumber implements RawType<String> {

    public static AccountNumber of(final String value) {
        return new AccountNumber(value);
    }

    private final String value;

    @Override
    public String get() {
        return value;
    }
}
