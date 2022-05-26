package ac.obl.paywent.eventbus.kafka;

import ac.obl.paywent.eventbus.QueueConfig;
import ac.obl.paywent.eventbus.RegisterTopicListener;
import ac.obl.paywent.eventbus.TopicListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegisterTopicListenerKafka implements RegisterTopicListener {

    private final QueueConfig queueConfig;

    @Override
    public TopicListener invoke(final String topic, final java.util.function.Consumer<String> externalConsumer) {
        //create kafka consumer
        final Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, queueConfig.getKafka());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        final Consumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singleton(topic));

        return new TopicListener() {
            boolean isRunning = true;
            private final Thread thread = new Thread(() -> {
                while (isRunning) {
                    final ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                    log.debug("Polled {} messages", records.count());
                    records.forEach(record -> {
                        externalConsumer.accept(record.value());
                    });
					consumer.commitAsync();
				}
			});

			@Override
			public TopicListener start() {
				isRunning = true;
				thread.start();
				return this;
			}

			@Override
			public void stop() {
				isRunning = false;
			}
		};
	}
}
