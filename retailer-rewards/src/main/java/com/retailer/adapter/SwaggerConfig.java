package com.retailer.adapter;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter{
	@Bean
public Docket retailerApi() {
	return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo()).select()
			 .apis(RequestHandlerSelectors.any())
	        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
	         .paths(PathSelectors.any())
			.apis(RequestHandlerSelectors.basePackage("com.retailer.controller")).paths(regex("/retailer.*")).build();
}
private ApiInfo apiInfo() {
	return new ApiInfoBuilder().title("Retail-Rewards Micro Service")
			.description("")
			.version("1.0")
			.termsOfServiceUrl("")				
			.license("SERVICE")				
			.licenseUrl("janakkp220@gmail.com").build();	

}
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) 
{
  //enabling swagger-ui part for visual documentation
  registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
  registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
}

}
