package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.AccountType;
import ac.obl.paywent.repository.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AccountEntity implements Identifiable<UUID> {

	@Id
	@GeneratedValue
	private UUID id;

	@Column
	private AccountType type;

	@Column
	private String name;

	@Column
	private String number;

	@Column
	private Instant updatedAt;

	@Column
	private Instant createdAt;

}
