package com.ecommerce.configuration;

import com.ecommerce.model.User;
import com.ecommerce.validator.UserValidator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ecommerce")
@PropertySource(value={"classpath:db.properties"})
public class SpringConfiguration extends WebMvcConfigurerAdapter {
    // Read file properties trong resources folder
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    Environment environment;

    // Bean set up return name file JSP (ViewResolver)
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return  viewResolver;
    }

    // Map resources folder for css, javascript, images
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    // Message Properties config
    @Bean
    public MessageSource messageSource () {
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();

        bundleMessageSource.setBasename("classpath:messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");

        return bundleMessageSource;
    }

    /* Validator to validate the User input --- su dung @Component trong class nen khong can khai bao bean o day
    @Bean
    public UserValidator userValidator() {

        return new UserValidator();
    } */

    // Bean MultipartResolver to upload file
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(-1);   // -1 = un-limit , dung luong tinh bang Byte

        return commonsMultipartResolver;
    }

    // JDBC template
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getProperty("driver"));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("username"));
        dataSource.setPassword(environment.getProperty("password"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

        bean.setDataSource(dataSource());
        bean.setPackagesToScan("com.ecommerce.entity");     // package de map class trong java app with database

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));        // generate ra cau lenh sql voi Database thich hop, MySQL, SQL sever, Oracle,...
        hibernateProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));     // hien thi cac cau lenh sql tren man hinh console

        bean.setHibernateProperties(hibernateProperties);
        return bean;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();

        hibernateTransactionManager.setSessionFactory(sessionFactory);

        return hibernateTransactionManager;
    }

    /*
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

        return jdbcTemplate;
    } */
}
