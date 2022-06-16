package ac.obl.paywent.payment;

import ac.obl.paywent.application.exception.UnmatchedAccountException;
import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.repository.account.VerifyAccountsProfile;
import ac.obl.paywent.web.payment.StorePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreatePaymentImpl implements CreatePayment {

    private final StorePayment storePayment;
    private final VerifyAccountsProfile verifyAccountsProfile;

    @Transactional
    @Override
    public Payment invoke(final NewPayment newPayment) {
        if (!verifyAccountsProfile.invoke(newPayment.getSender(), newPayment.getOriginator())) {
            throw new UnmatchedAccountException(newPayment.getSender());
        }
        if (!verifyAccountsProfile.invoke(newPayment.getReceiver(), newPayment.getBeneficiary())) {
            throw new UnmatchedAccountException(newPayment.getSender());
        }

        return storePayment.invoke(newPayment);
    }
}
