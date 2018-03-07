package com.kavinaam.springdemo.config;

import com.kavinaam.springdemo.interceptors.ExecutionTimerInterceptor;
import com.kavinaam.springdemo.interceptors.HeaderInterceptor;
import com.kavinaam.springdemo.interceptors.VisitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.kavinaam.springdemo")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private HeaderInterceptor headerInterceptor;

    @Autowired
    private ExecutionTimerInterceptor executionTimerInterceptor;

    @Autowired
    private VisitorInterceptor  visitorInterceptor;

    @Bean
    public UrlBasedViewResolver viewResolver(){
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }

   /* @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.setUseSuffixPatternMatch(true);
        requestMappingHandlerMapping.setUseTrailingSlashMatch(true);

        return requestMappingHandlerMapping;
    }*/

    @Bean
    public DataSource dataSource(){
        JndiDataSourceLookup sourceLookup = new JndiDataSourceLookup();
        sourceLookup.setResourceRef(true);
        DataSource dataSource = sourceLookup.getDataSource("jdbc/springdb");

        return dataSource;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("testMvcHome");
//        <mvc:view-controller path = "/" view-name = "home" />
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor);
        registry.addInterceptor(executionTimerInterceptor).addPathPatterns("/location");
        registry.addInterceptor(visitorInterceptor);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/css/test/");
    }

    @Bean(name = "SeviceLengthOptions")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocation(new ClassPathResource("test/organization-val.properties"));
        return factoryBean;
    }
}
