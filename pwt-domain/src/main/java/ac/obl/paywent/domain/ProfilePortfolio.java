package ac.obl.paywent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class ProfilePortfolio {
    private final Profile profile;
    private final List<Account> accounts;
}
