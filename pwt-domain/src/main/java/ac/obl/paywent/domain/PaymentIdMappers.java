package ac.obl.paywent.domain;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

public interface PaymentIdMappers {

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.CLASS)
	@interface MapPaymentIdToUuid {
	}

	@MapPaymentIdToUuid
	default UUID mapPaymentIdToUuid(final PaymentId paymentId) {
		return paymentId.getId();
	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.CLASS)
	@interface MapUuidToPaymentId {
	}

	@MapUuidToPaymentId
	default PaymentId mapUuidToPaymentId(final UUID uuid) {
		return new PaymentId(uuid);
	}

	@Qualifier
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.CLASS)
	@interface MapPaymentIdToString {
	}

	@MapPaymentIdToString
	default String mapPaymentIdToString(final PaymentId paymentId) {
		return paymentId.toString();
	}

}
