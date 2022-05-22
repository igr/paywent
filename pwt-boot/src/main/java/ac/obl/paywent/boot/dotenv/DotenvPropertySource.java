package ac.obl.paywent.boot.dotenv;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;

@Slf4j
public class DotenvPropertySource extends PropertySource<DotenvPropertyLoader> {

    public static final String DOTENV_PROPERTY_SOURCE_NAME = "env";
    private static final String PREFIX = DOTENV_PROPERTY_SOURCE_NAME + ".";

    public DotenvPropertySource(final String name) {
        super(name, new DotenvPropertyLoader());
    }

    public DotenvPropertySource() {
        this(DOTENV_PROPERTY_SOURCE_NAME);
    }

    /**
     * Return the value associated with the given name, or {@code null} if not found.
     */
    @Override
    public Object getProperty(final String name) {
        if (!name.startsWith(PREFIX)) {
            return null;
        }

        if (logger.isTraceEnabled()) {
            logger.trace("Getting env property for '" + name + "'");
        }

        return getSource().getValue(name.substring(PREFIX.length()));
    }

    public static void addToEnvironment(final ConfigurableEnvironment environment) {
        environment
            .getPropertySources()
            .addAfter(
                StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,
                new DotenvPropertySource(DOTENV_PROPERTY_SOURCE_NAME));

        log.debug(".env added to environment");
    }
}
