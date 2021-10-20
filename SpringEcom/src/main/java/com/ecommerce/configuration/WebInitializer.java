package com.ecommerce.configuration;

import com.ecommerce.configuration.SpringConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext config = new AnnotationConfigWebApplicationContext();

        config.register(SpringConfiguration.class);

        config.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(config));

        servlet.setLoadOnStartup(1);

        servlet.addMapping("/");

        // Filter UTF-8
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);

        container.addFilter("encodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, false, "/*");

    }
}
