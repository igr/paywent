package ac.obl.paywent.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
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
