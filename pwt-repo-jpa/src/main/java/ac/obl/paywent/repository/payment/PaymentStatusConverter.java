package ac.obl.paywent.repository.payment;

import ac.obl.paywent.domain.PaymentStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class PaymentStatusConverter implements javax.persistence.AttributeConverter<PaymentStatus, String> {
	@Override
	public String convertToDatabaseColumn(final PaymentStatus paymentStatus) {
		return paymentStatus.name().toLowerCase();
	}

	@Override
	public PaymentStatus convertToEntityAttribute(final String value) {
		return PaymentStatus.valueOf(value.toUpperCase());
	}
}
