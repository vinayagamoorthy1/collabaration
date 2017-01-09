package com.niit.collabaration.ApplicationContextConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.collabaration.model.User;

@Configuration
@ComponentScan("com.niit.collabaration.*")
public class ApplicationContextConfig {
	@Bean(name="dataSource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		 datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		 datasource.setUsername("MOORTHY");
	    	datasource.setPassword("root");
	    	Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        datasource.setConnectionProperties(properties);

	    	
	    	return datasource;
	}
	 
	  @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addAnnotatedClasses(User.class);
	    	return sessionBuilder.buildSessionFactory();
	  }

	 @Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
}