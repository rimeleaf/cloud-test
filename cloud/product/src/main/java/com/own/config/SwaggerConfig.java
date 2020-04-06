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
 * @date: 2020/4/5 16:49
 */
@SpringBootConfiguration
@EnableSwagger2
@EnableKnife4j
@Import({BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {
    @Bean
    public Docket ordertApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("1-订单服务").select()
                .apis(RequestHandlerSelectors.basePackage("com.own.controller")).paths(PathSelectors.any()).build()
                .apiInfo(orderInfo());
    }

    public ApiInfo orderInfo() {
        // 大标题
        return new ApiInfoBuilder().title("微服务测试")
                // 详细描述
                .description("订单接口")
                // 版本
                .version("1.0")
                .termsOfServiceUrl("").contact(new Contact("甘建兴", "微服务测试", "own")).license("").licenseUrl("")
                .build();

    }


}
