package com.wangwei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig是一个配置文件
 * EnableSwagger2 加载配置文件
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     *pathMapping 访问路径
     * paths 选择器 匹配servlet访问路径方法
     * @return
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我的接口测试文档--王伟").
                contact(new Contact("wangwei","","1097677411@qq.com"))
                .description("这是我的第一个SwaggerUI接口文档")
                .version("v1").build();
    }
}
