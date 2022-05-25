package ac.obl.paywent.boot;

import ac.obl.paywent.AppRunningContext;
import ac.obl.paywent.StartApplication;
import ac.obl.paywent.StopApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
@RequiredArgsConstructor
public class WebApplicationLifecycle {

    private final StartApplication startApplication;
    private final StopApplication stopApplication;

    private AppRunningContext context;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationStart() {
        this.context = startApplication.invoke();
    }

    @PreDestroy
    public void onApplicationEnd() {
        stopApplication.invoke(context);
    }


}
