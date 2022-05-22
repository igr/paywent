package ac.obl.paywent.boot.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties("app")
@Component
@RequiredArgsConstructor
public class AppProperties {

	/**
	 * Application name.
	 */
	private String name;

	/**
	 * Application ID.
	 */
	private String id;

}