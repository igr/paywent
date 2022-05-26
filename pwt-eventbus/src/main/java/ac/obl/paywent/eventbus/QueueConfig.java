package ac.obl.paywent.eventbus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QueueConfig {
	private final boolean enabled;
	private final String kafka;
}
