package ac.obl.paywent.repository.payment;

import ac.obl.paywent.domain.AccountIdMappers;
import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.domain.PaymentIdMappers;
import ac.obl.paywent.domain.PaymentStatus;
import ac.obl.paywent.domain.ProfileIdMappers;
import ac.obl.paywent.map.PwtMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = PwtMapperConfig.class)
public interface PaymentEntityMapper extends PaymentIdMappers, ProfileIdMappers, AccountIdMappers {

	@Mapping(target = "id", source = "id", qualifiedBy = MapUuidToPaymentId.class)
	@Mapping(target = "originator", source = "originator", qualifiedBy = MapUUIDToProfileId.class)
	@Mapping(target = "beneficiary", source = "beneficiary", qualifiedBy = MapUUIDToProfileId.class)
	@Mapping(target = "sender", source = "sender", qualifiedBy = MapUUIDToAccountId.class)
	@Mapping(target = "receiver", source = "receiver", qualifiedBy = MapUUIDToAccountId.class)
	Payment toModel(PaymentEntity accountEntity);

	default PaymentEntity toEntity(final NewPayment newPayment) {
		return PaymentEntity.builder()
				.amount(newPayment.getAmount())
				.currency(newPayment.getCurrency())
				.originator((newPayment.getOriginator().getId()))
				.beneficiary(newPayment.getBeneficiary().getId())
				.sender(newPayment.getSender().getId())
				.receiver(newPayment.getReceiver().getId())
				.status(PaymentStatus.CREATED)
				.build();
	}

}
