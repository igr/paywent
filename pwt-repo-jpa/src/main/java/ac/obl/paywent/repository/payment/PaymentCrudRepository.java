package ac.obl.paywent.repository.payment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentCrudRepository extends CrudRepository<PaymentEntity, UUID> {

	@Query(value =
			"UPDATE payments SET status='sent' " +
					"WHERE id IN (" +
					"  SELECT id FROM payments " +
					"  WHERE status = 'created' " +
					"  ORDER BY created_at " +
					"  FOR UPDATE SKIP LOCKED " +
					"  LIMIT ?1" +
					")" +
					"RETURNING *;", nativeQuery = true)
	List<PaymentEntity> selectCreatedPayments(int batchSize);

}
