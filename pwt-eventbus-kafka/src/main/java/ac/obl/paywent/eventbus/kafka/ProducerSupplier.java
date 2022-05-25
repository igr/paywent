package ac.obl.paywent.eventbus.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Supplier;

@Component
public class ProducerSupplier implements Supplier<Producer<String, String>> {
	private Producer<String, String> producer;

	public void register(final Producer<String, String> producer) {
		if (this.producer != null) {
			throw new IllegalStateException("Producer already registered");
		}
		this.producer = producer;
	}

	@Override
	public Producer<String, String> get() {
		Objects.requireNonNull(this.producer, "Producer not registered");
		return producer;
	}

}
