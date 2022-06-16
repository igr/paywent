package ac.obl.paywent.application.exception;

import ac.obl.paywent.domain.AccountId;

public class UnmatchedAccountException extends PwtException {
    public UnmatchedAccountException(final AccountId accountId) {
        super("Account not matched to its profile: " + accountId);
    }
}
