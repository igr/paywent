package ac.obl.paywent.boot;

import ac.obl.paywent.StartApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
@RequiredArgsConstructor
public class WebApplicationLifecycle {

    private final StartApplication startApplication;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationStart() {
        startApplication.invoke();
    }

    @PreDestroy
    public void onApplicationEnd() {
    }


}
