package ac.obl.paywent.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OpenApiController {

    @GetMapping(value = "/openapi.yaml", produces = "text/plain; charset=utf-8")
    @ResponseBody
    public Resource openapi() {
        return new ClassPathResource("openapi.yaml");
    }
}
