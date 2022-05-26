package ac.obl.paywent.eventbus.kafka;

import ac.obl.paywent.eventbus.ConnectToEventBus;
import ac.obl.paywent.eventbus.QueueConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConnectToEventBusKafka implements ConnectToEventBus {
	private final ProducerSupplier producerSupplier;

	private final QueueConfig queueConfig;

	@Override
	public void invoke() {
		final Properties properties = kafkaProperties(queueConfig.getKafka());
		final Producer<String, String> producer = new KafkaProducer<>(properties);
		producerSupplier.register(producer);
		log.info("Connected to Kafka: {}", queueConfig.getKafka());
	}

	private static Properties kafkaProperties(final String kafkaUrlAndPort) {
		final Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrlAndPort);
		properties.put("sasl.mechanism", "PLAIN");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put("retries", 3);
		properties.put("max.request.size", 1024 * 1024); // limit request size to 1MB
		return properties;
	}
}
