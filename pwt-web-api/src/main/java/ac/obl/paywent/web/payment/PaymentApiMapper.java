package ac.obl.paywent.web.payment;

import ac.obl.paywent.domain.AccountIdMappers;
import ac.obl.paywent.domain.NewPayment;
import ac.obl.paywent.domain.Payment;
import ac.obl.paywent.domain.PaymentIdMappers;
import ac.obl.paywent.domain.ProfileIdMappers;
import ac.obl.paywent.map.PwtMapperConfig;
import ac.obl.paywent.web.model.NewPaymentRequest;
import ac.obl.paywent.web.model.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = PwtMapperConfig.class)
public interface PaymentApiMapper extends PaymentIdMappers, ProfileIdMappers, AccountIdMappers {

	@Mapping(target = "originator", source = "originator", qualifiedBy = MapStringToProfileId.class)
	@Mapping(target = "beneficiary", source = "beneficiary", qualifiedBy = MapStringToProfileId.class)
	@Mapping(target = "sender", source = "sender", qualifiedBy = MapStringToAccountId.class)
	@Mapping(target = "receiver", source = "receiver", qualifiedBy = MapStringToAccountId.class)
	NewPayment mapToNewPayment(NewPaymentRequest newPaymentRequest);

	@Mapping(target = "originator", source = "originator", qualifiedBy = MapProfileIdToString.class)
	@Mapping(target = "beneficiary", source = "beneficiary", qualifiedBy = MapProfileIdToString.class)
	@Mapping(target = "sender", source = "sender", qualifiedBy = MapAccountIdToString.class)
	@Mapping(target = "receiver", source = "receiver", qualifiedBy = MapAccountIdToString.class)
	@Mapping(target = "id", source = "id", qualifiedBy = MapPaymentIdToString.class)
	PaymentResponse mapToPaymentResponse(Payment payment);

}
