package ac.obl.paywent.domain;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public interface TimeMappers {

	default OffsetDateTime map(final Instant instant) {
		return OffsetDateTime.ofInstant(instant, ZoneId.of("UTC"));
	}
}
