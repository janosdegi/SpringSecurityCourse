package com.springsecuritycourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Dégi János on 2017.09.23..
 */
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {

    // Declare a datasource that has pooling capabilities
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/envisy");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(dataSource());
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

    // Declare a JPA entityManagerFactory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
        em.setPersistenceUnitName("jpa_envisy");
        em.setDataSource(dataSource());

        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setShowSql(false);
        em.setJpaVendorAdapter(vendor);

        return em;
    }

}
