package com.module1.project1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class appConfig {

    @Bean
    @Scope("prototype")
    paymentService paymentService(){
        return new paymentService();
    }

    @PostConstruct
    void beforeBeanCreation(){
        System.out.println("Before Bean Creation");
    }

    @PreDestroy
    void afterBeanCreation(){
        System.out.println("after Bean Creation");
    }


}
