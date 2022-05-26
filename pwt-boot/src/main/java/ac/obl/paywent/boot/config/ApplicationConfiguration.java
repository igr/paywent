package ac.obl.paywent.boot.config;

import ac.obl.paywent.PaywentProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import static ac.obl.paywent.boot.config.ApplicationConfiguration.ALL_CLASSES;

@Configuration
@ComponentScan(basePackages = ALL_CLASSES)
@EnableJpaRepositories(basePackages = ALL_CLASSES)
@EntityScan(basePackages = ALL_CLASSES)
@EnableScheduling
@Import(EndpointAutoConfiguration.class)
@EnableConfigurationProperties(AppProperties.class)
public class ApplicationConfiguration {

    public static final String ALL_CLASSES = "ac.obl.paywent*";

    @ConfigurationProperties(prefix = "pwt")
    @Bean
    public PaywentProperties paywentProperties() {
        return new PaywentProperties();
    }

}
