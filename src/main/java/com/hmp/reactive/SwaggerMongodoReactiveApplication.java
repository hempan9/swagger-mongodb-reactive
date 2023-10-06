package com.hmp.reactive;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot web-flux reactive application REST-API documentation",
                description = "This application is example of reactive controllers using spring boot reactive core library with OPENAPI 3 standard api documentation",
                version = "1.0",
                contact = @Contact(
                        name = "Hemanta Pant",
                        url = "https://www.github.com/hempan9",
                        email = "hemantapant9@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0")
        )
)
@SpringBootApplication
public class SwaggerMongodoReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerMongodoReactiveApplication.class, args);
    }

}
