package com.aks.woorimtech.common.config;

import javax.annotation.Resource;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aks.woorimtech.common.annotation.Comment;
import com.aks.woorimtech.common.util.BeanUtil;

@Comment("application-context.xml Role")
@Configuration
@ComponentScan(basePackages= {"com.aks.woorimtech"}, excludeFilters = @ComponentScan.Filter(Controller.class))
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
@EnableAutoConfiguration // 자동설정 활성화
public class ApplicationConfig{
	
	@Resource
	ApplicationContext applicationContext;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public BeanUtil beanUtil() {
		return new BeanUtil();
	}
}