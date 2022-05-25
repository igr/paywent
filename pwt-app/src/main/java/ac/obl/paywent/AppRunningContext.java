package ac.obl.paywent;

import ac.obl.paywent.eventbus.TopicListener;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Represents a running context of the application, created on startup.
 * It is used on shutdown.
 */
@Data
@RequiredArgsConstructor
@Builder
public class AppRunningContext {
	private final TopicListener topicListener;
}
