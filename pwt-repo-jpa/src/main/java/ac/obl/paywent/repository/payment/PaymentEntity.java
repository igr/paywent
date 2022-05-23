package ac.obl.paywent.repository.payment;

import ac.obl.paywent.domain.PaymentStatus;
import ac.obl.paywent.repository.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PaymentEntity implements Identifiable<UUID> {

	@Id
	@GeneratedValue
	private UUID id;

	@Column
	private String amount;

	@Column
	private String currency;

	@Column
	private UUID originator;

	@Column
	private UUID beneficiary;

	@Column
	private UUID sender;

	@Column
	private UUID receiver;

	@Column
	private PaymentStatus status;

	@UpdateTimestamp
	private Instant updatedAt;

	@CreationTimestamp
	private Instant createdAt;


}
