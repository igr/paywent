package ac.obl.paywent;

import org.springframework.stereotype.Component;

@Component
public class StopApplicationImpl implements StopApplication {

	@Override
	public void invoke(AppRunningContext appRunningContext) {
		appRunningContext.getTopicListener().stop();
	}

}
