package com.afkghouri.UsedGraphenee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "myEntityManagerFactory", transactionManagerRef = "myTransactionManager")
public class PersistenceJPAConfig {

		@Value("${spring.datasource.url}")
		String dbUrl;
	
		@Value("${spring.datasource.username}")
		String dbUsername;
	
		@Value("${spring.datasource.password}")
		String dbPassword;
		
		@Value("${spring.datasource.driver-class-name}")
		String driverName;
	
	   @Bean("myTransactionManager")
	   @Primary
	   public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		   System.out.println("transactionManager");
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(emf); 
	       return transactionManager;
	   }
	   @Bean("myEntityManagerFactory")
	   @Primary
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		   System.out.println("entityManagerFactory"); 
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(getDataSource());
	      em.setPackagesToScan(PersistenceJPAConfig.class.getPackage().getName());
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter); 
	      return em;
	   }
	   
	   @Bean
	   @Primary
	   public DataSource getDataSource(){
		  System.out.println("getDataSource"); 
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(driverName);
	      dataSource.setUrl(dbUrl);
	      dataSource.setUsername( dbUsername);
	      dataSource.setPassword( dbPassword );
	      return dataSource;
	   }
	    
}
