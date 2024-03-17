package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.demo.filter.IdNumberFilter;
import com.example.demo.filter.UserFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<UserFilter> setUserFilter() {
        FilterRegistrationBean<UserFilter> filterRegistrationBean = new FilterRegistrationBean<UserFilter>(new UserFilter());
        filterRegistrationBean.addUrlPatterns("/login");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;		
	}

        
        @Bean
	public FilterRegistrationBean<IdNumberFilter> setIdNumberFilter() {
        FilterRegistrationBean<IdNumberFilter> filterRegistrationBean = new FilterRegistrationBean<IdNumberFilter>(new IdNumberFilter());
        filterRegistrationBean.addUrlPatterns("/search");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;		
	}
        
	
}
