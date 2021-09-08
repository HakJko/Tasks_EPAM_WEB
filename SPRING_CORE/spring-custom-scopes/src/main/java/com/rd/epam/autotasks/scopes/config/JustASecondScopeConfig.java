package com.rd.epam.autotasks.scopes.config;

import com.rd.epam.autotasks.scopes.config.justasecond.JustSecondBeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.rd.epam.autotasks.scopes.config.justasecond")
public class JustASecondScopeConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new JustSecondBeanFactoryPostProcessor();
    }

}
