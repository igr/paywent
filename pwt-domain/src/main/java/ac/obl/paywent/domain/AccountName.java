package ac.obl.paywent.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountName implements RawType<String> {

    public static AccountName of(final String value) {
        return new AccountName(value);
    }

    private final String value;

    @Override
    public String get() {
        return value;
    }
}
