package com.globallink.ctm.db.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ConditionalOnClass(DataSource.class)
public class DBConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(DBConfiguration.class);
	
	public static String DB_APP_NAME = "FXCTSDB";
	
	private @Value("${spring.datasource.username}") String username;
	
	private @Value("${spring.datasource.password}") String password;
	
	private @Value("${spring.datasource.url}") String url;
	
	private @Value("${spring.datasource.driver.class}") String driver;

	@Bean
	@ConditionalOnBean(name = "dataSource")
	@ConditionalOnMissingBean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return em;
	}

	@Bean
	public DataSource dataSource() {
		LOGGER.info("Creating custom datasource for user {} **************************************", username); 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	private String getPassword() {
		return null;
	}
}
