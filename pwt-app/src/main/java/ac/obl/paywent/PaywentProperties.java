package ac.obl.paywent;

import lombok.Data;

@Data
public class PaywentProperties {

	@Data
	public class Queue {

		private boolean enabled = true;
	}

	private final Queue queue = new Queue();
}
