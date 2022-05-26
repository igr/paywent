package ac.obl.paywent.boot;

import ac.obl.paywent.AppRunningContext;
import ac.obl.paywent.StartApplication;
import ac.obl.paywent.StopApplication;
import ac.obl.paywent.boot.config.AppProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebApplicationLifecycle {

    private final StartApplication startApplication;
    private final StopApplication stopApplication;

    private final AppProperties appProperties;

    private AppRunningContext context;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationStart() {
        log.info("Starting application: {}", appProperties.getName());
        this.context = startApplication.invoke();
    }

    @PreDestroy
    public void onApplicationEnd() {
        stopApplication.invoke(context);
    }


}
