package com.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
@EnableWebMvc  //必须存在
//必须存在，扫描的API Controller包
@ComponentScan(basePackages = {"com.swagger.controller"})
public class SwaggerConfig {
    @Bean
    public Docket customDocket(){return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());}

    private ApiInfo apiInfo(){
        Contact contact = new Contact("GodF","https://www.baidu.com","1396537376@qq.com");
        return new ApiInfoBuilder().title("GodF的API接口")
                                    .description("API接口")
                                    .contact(contact).version("1.1.0").build();
    }
}
