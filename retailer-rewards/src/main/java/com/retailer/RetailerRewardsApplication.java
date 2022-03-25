package com.retailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.retailer.adapter.SwaggerConfig;

/**
 * 
 * @author Janak Patel
 */
@EnableWebMvc
@SpringBootApplication
@Import(SwaggerConfig.class)
public class RetailerRewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerRewardsApplication.class, args);
	}

}
