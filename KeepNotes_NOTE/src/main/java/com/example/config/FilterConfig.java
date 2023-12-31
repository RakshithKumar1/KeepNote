package com.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.example.filter.JWTValidationFilter;

@Configuration
public class FilterConfig {
	public static final String CONTACTS_PATH = "/note/*";
	
	@Bean
	public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
		FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JWTValidationFilter());
		filterRegistrationBean.addUrlPatterns(CONTACTS_PATH);
		return filterRegistrationBean;
	}
	
}
