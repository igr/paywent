package ac.obl.paywent.boot.config;

import ac.obl.paywent.eventbus.QueueConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConfigurationProperties("app")
@ConstructorBinding
public class AppProperties {

	/**
	 * Application name.
	 */
	private final String name;

	/**
	 * Application ID.
	 */
	private final String id;

	/**
	 * Queue configuration.
	 */
	private final QueueConfig queue;

}