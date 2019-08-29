package com.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {
    //必须放在最外层，自动扫描同级别的包及同级别包下的所有类
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
