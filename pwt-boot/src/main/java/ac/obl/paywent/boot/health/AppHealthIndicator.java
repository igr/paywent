package ac.obl.paywent.boot.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
@Slf4j
public class AppHealthIndicator implements HealthIndicator {

	final String buildId;
	final String buildTime;

	public AppHealthIndicator(@Value("classpath:git.properties") final Resource resource) {
		final var p = new Properties();

		try {
			p.load(resource.getInputStream());
		} catch (final IOException e) {
			log.error("Git version not available", e);
		}

		buildId = (String) p.get("git.commit.id.full");
		buildTime = (String) p.get("git.build.time");
	}

	@Override
	public Health health() {
		return Health.up()
				.withDetail("build-id", buildId)
				.withDetail("build-time", buildTime)
				.build();
	}
}
