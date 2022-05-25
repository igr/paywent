package ac.obl.paywent.eventbus.kafka;

import ac.obl.paywent.eventbus.SendMessageToEventBus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendMessageToEventBusKafka implements SendMessageToEventBus {

	private final ProducerSupplier producerSupplier;

	@Override
	public void invoke(final String topic, final String message) {
		log.info("Sending message to topic: {}", topic);
		final ProducerRecord<String, String> record = new ProducerRecord<>(topic, null, message);
		final var future = producerSupplier.get().send(record);
		producerSupplier.get().flush();

		try {
			log.debug("Waiting to send");
			future.get();
			log.debug("After");
		} catch (final InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
