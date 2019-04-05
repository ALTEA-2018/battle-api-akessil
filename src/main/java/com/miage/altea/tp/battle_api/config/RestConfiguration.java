package com.miage.altea.tp.battle_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfiguration {

    private String userName;
    private String password;

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    RestTemplate trainerApiRestTemplate(){
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor(userName, password);
        interceptors.add(interceptor);

        RestTemplate restTemplate = new  RestTemplate();
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Value("${trainer.service.username}")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Value("${trainer.service.password}")
    public void setPassword(String password) {
        this.password = password;
    }
}
