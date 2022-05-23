package ac.obl.paywent.web.payment;

import ac.obl.paywent.domain.PaymentId;
import ac.obl.paywent.payment.AcceptPayment;
import ac.obl.paywent.payment.GetPayment;
import ac.obl.paywent.web.PaymentsApi;
import ac.obl.paywent.web.model.NewPaymentRequest;
import ac.obl.paywent.web.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentsApiImpl implements PaymentsApi {

	private final GetPayment getPayment;
	private final AcceptPayment acceptPayment;
	private final PaymentApiMapper mapper;

	@Override
	public ResponseEntity<PaymentResponse> _getPaymentId(final String id) {
		final var payment = getPayment.invoke(new PaymentId(id));
		return ResponseEntity.of(payment.map(mapper::mapToPaymentResponse));
	}

	@Override
	public ResponseEntity<PaymentResponse> _postPayments(final NewPaymentRequest newPaymentRequest) {
		final var newPayment = mapper.mapToNewPayment(newPaymentRequest);
		final var payment = acceptPayment.invoke(newPayment);
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body((mapper.mapToPaymentResponse(payment)));
	}
}
