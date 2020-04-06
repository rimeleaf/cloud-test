package com.own.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: SwaggerConfig
 * @Descripe： <br>
 * @package: com.own.config
 * @author: MECHREV
 * @date: 2020/4/6 20:42
 */
@SpringBootConfiguration
@EnableSwagger2
@EnableKnife4j
@Import({BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {
    @Bean
    public Docket payAllDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("支付服务")
                .select().apis(RequestHandlerSelectors.basePackage("com.own.controller"))
                .paths(PathSelectors.any()).build().apiInfo(payApiInfo());

    }

    public ApiInfo payApiInfo() {
        return new ApiInfoBuilder().title("cloud-支付模块")
                .description("支付接口")
                .version("1.0")
                .termsOfServiceUrl("").contact(new Contact("甘建兴", "微服务测试", "own")).license("").licenseUrl("")
                .build();
    }
}
