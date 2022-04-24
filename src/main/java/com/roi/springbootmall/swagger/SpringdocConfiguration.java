package com.roi.springbootmall.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title ="Spring boot Mall", version = "v1.0.0"))
public class SpringdocConfiguration {
}
