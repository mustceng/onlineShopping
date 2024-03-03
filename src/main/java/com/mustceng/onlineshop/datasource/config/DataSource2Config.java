package com.mustceng.onlineshop.datasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondaryEntityManagerFactory",
		transactionManagerRef = "secondaryTransactionManager",
		basePackages = "com.mustceng.onlineshop.repository2"
)
public class DataSource2Config {

	@Autowired
	private Environment env;

	@Primary
	@Bean(name="secondaryDataSource")
	public DataSource secondaryDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty("spring.datasource.db2.url"));
		ds.setUsername(env.getProperty("spring.datasource.db2.username"));
		ds.setPassword(env.getProperty("spring.datasource.db2.password"));
		ds.setDriverClassName(env.getProperty("spring.datasource.db2.driver-class-name"));
		return ds;
	}

@Primary
@Bean(name = "secondaryEntityManagerFactory")
public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(secondaryDataSource());
	JpaVendorAdapter adapter =new HibernateJpaVendorAdapter();
	bean.setJpaVendorAdapter(adapter);
	HashMap <String,Object> properties = new HashMap<String,Object>();
	properties.put("hibernate.hbm2ddl.auto","update");
	properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
	bean.setJpaPropertyMap(properties);
	bean.setPackagesToScan("com.mustceng.onlineshop.entity2");
	return bean;
	}

	@Bean(name = "secondaryTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory secondaryEntityManagerFactory) {
		return new JpaTransactionManager(secondaryEntityManagerFactory);
	}


}

