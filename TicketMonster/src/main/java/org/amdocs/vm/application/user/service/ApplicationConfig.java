package org.amdocs.vm.application.user.service;


import org.amdocs.vm.application.user.User;
import org.amdocs.vm.application.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public UserService getUserService(){
        return new UserService();
    }
}
