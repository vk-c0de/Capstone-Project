package org.npci.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

   @Bean
   public OpenAPI registrationOpenAPI() {
       return new OpenAPI()
               .info(new Info().title("Swagger API Docs Howtofixthebugs")
                       .description("Howtofixthebugs API Description")
                       .version("1.0"));
   }
}