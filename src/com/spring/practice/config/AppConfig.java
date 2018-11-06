package com.spring.practice.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.practice.dao.AppDaoImpl;

@Configuration
public class AppConfig {
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/springsecurity?useSSL=false");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("raihan");
		return dataSource;
	}
	
	@Bean(name="daoBean")
	public AppDaoImpl appDao() {
		return new AppDaoImpl(getDataSource());
	}
}
