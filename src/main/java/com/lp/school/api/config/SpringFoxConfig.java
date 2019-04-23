package com.lp.school.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.google.common.base.Predicates;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SpringFoxConfig {

  @Bean
  public Docket apiDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(Predicates.not(RequestHandlerSelectors.withClassAnnotation(ApiIgnore.class)))
        .apis(RequestHandlerSelectors.basePackage("com.lp.school.api"))
        .build();
  }
}