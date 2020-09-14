package com.edu.restwebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.edu.restwebapp.controllers")
public class WebConfig {
    @Bean
    public DataSource dataSource(Environment env) {
        DriverManagerDataSource dtsource = new DriverManagerDataSource();
        dtsource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dtsource.setUrl(env.getRequiredProperty("db.url"));
        dtsource.setUsername(env.getRequiredProperty("db.username"));
        dtsource.setPassword(env.getRequiredProperty("db.password"));

        return dtsource;
    }

    /*
    Entity manager
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.edu.restwebapp.models");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);

        Properties jpaProps = new Properties();
        jpaProps.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        jpaProps.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        jpaProps.setProperty("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
        jpaProps.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        jpaProps.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        factoryBean.setJpaProperties(jpaProps);

        return factoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
