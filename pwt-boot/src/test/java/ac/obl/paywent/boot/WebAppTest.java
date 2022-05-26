package ac.obl.paywent.boot;

import ac.obl.paywent.boot.dotenv.DotenvApplicationInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = WebApplication.class)
@ContextConfiguration(initializers = {
    DotenvApplicationInitializer.class
})
@RequiredArgsConstructor
@ActiveProfiles({"local", "test"})
public abstract class WebAppTest {


}
