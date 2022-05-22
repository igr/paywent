package ac.obl.paywent.boot;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.web.context.support.GenericWebApplicationContext;

/**
 * SpringBoot initializer that is executed before the ApplicationContext is ready.
 */
@Slf4j
public class WebApplicationInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String ALL_CLASSES = "ac.obl.paywent.*";

    @Override
    public void initialize(@NotNull final ConfigurableApplicationContext applicationContext) {
        final var webApplicationContext = (GenericWebApplicationContext) applicationContext;
        registerAppComponentsOnClasspath(webApplicationContext);
    }

    private static void registerAppComponentsOnClasspath(final BeanDefinitionRegistry beanDefinitionRegistry) {
        final var scanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry, false);

        scanner.setIncludeAnnotationConfig(false);
//        scanner.addIncludeFilter(new AnnotationTypeFilter(AppComponent.class));

        final int beanCount = scanner.scan(ALL_CLASSES);

        log.info("Registered {} app components", beanCount);
    }

}
