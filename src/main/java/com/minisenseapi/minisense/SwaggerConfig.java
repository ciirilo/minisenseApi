package com.minisenseapi.minisense;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.minisenseapi.minisense.api.controllers"))
          .paths(PathSelectors.any())
          .build()
          .useDefaultResponseMessages(false)
          .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
          .apiInfo(apiInfo());
    }
    
    
    

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MiniSense-Api")
                .description("Uma simples Api para IOT")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Paulo", "https://github.com/ciirilo", "pmachado.new@gmail.com"))
                .build();
    }
    
	private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                .code(500)
                .message("500 message")
                .build());
            add(new ResponseMessageBuilder()
                .code(403)
                .message("Forbidden!")
                .build());
            add(new ResponseMessageBuilder()
                    .code(404)
                    .message("Not Found!")
                    .build());
        }};
    }
 

}
