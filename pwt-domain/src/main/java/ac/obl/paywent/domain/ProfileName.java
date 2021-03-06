package ac.obl.paywent.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfileName implements RawType<String> {

    public static ProfileName of(final String value) {
        return new ProfileName(value);
    }

    private final String value;

    @Override
    public String get() {
        return value;
    }
}
