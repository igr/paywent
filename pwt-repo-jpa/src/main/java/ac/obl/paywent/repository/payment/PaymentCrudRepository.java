package ac.obl.paywent.repository.payment;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentCrudRepository extends CrudRepository<PaymentEntity, UUID> {
}
