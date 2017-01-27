package com.devendra.gateway;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.devendra.gateway.service.PostService;
import com.devendra.gateway.service.UserService;

@SpringBootApplication
@EnableCaching
public class Application extends AsyncConfigurerSupport {

    @Bean
    PostService postService() {
        return new PostService();
    }


    @Bean
    UserService userService() {
        return new UserService();
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }

}
