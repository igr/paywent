package ac.obl.paywent;

import ac.obl.paywent.eventbus.TopicListener;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class AppRunningContext {
	private final TopicListener topicListener;
}
