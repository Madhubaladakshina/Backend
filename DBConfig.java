package com.ecomm.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
public class DBConfig {
	@Bean	
	public DataSource getH2Datasources(){
	
		DriverManagerDataSource datasources =new DriverManagerDataSource();
		datasources.setDriverClassName("org.h2.Driver");
		datasources.setUrl("jdbc:h2:tcp://localhost/~/Project23");
		datasources.setUsername("madhu");
		datasources.setPassword("123");
		System.out.println("Datasources object created");
		return datasources;
		
		
	}
	@Bean(name="SessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateprop=new Properties();
		hibernateprop.put("hibernate.hbm2ddl.auto","update");
		hibernateprop.put("hibernate.dialect", "org.hibernate.dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2Datasources());
		factory.addProperties(hibernateprop);
		SessionFactory sessionFactory=factory.buildSessionFactory();
		System.out.println("SessionFactory object created");
		return sessionFactory;
	}
	@Bean("txt Manager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hiberante transcation Manager");
		return new HibernateTransactionManager(sessionFactory);
		
		
		
	}
	

}
