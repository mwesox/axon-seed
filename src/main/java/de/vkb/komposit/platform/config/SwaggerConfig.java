package de.vkb.komposit.platform.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("VKB-kompas-platform")
                .apiInfo(apiInfo())
                .select()
                //Ignores controllers annotated with @CustomIgnore
                .apis(Predicates.alwaysTrue()) //Selection by RequestHandler
                        .paths(paths()) // and by paths
                        .build();
                  //      .apiInfo(apiInfo())
                    //    .securitySchemes(securitySchemes())
                      //  .securityContext(securityContext())

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("VKB Kompas Platform")
                .description("Tolle neue API")
                .contact(
                        new Contact(
                                "Name",
                                "URL",
                                "test@email.de"
                        )
                )
                .license("License details")
                .licenseUrl("License url")
                .version("0.1")
                .build();
    }

    //Here is an example where we select any api that matches one of these paths
    private Predicate<String> paths() {
        return or(
                regex("/vorschlag.*"),
                regex("/vertrag.*"),
                regex("/produkt.*"),
                regex("/antrag.*")
);
    }
}
