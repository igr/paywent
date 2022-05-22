package ac.obl.paywent.boot;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class WebApplicationLifecycle {

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationStart() {
    }

    @PreDestroy
    public void onApplicationEnd() {
    }


}
