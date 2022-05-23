package ac.obl.paywent.boot;

import ac.obl.paywent.boot.dotenv.DotenvApplicationInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebApplication {

    public static void main(final String[] args) {
        new SpringApplicationBuilder(WebApplication.class)
                .initializers(
                        new DotenvApplicationInitializer()
                )
                .run(args);
    }

}
