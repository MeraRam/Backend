package com.build.suchane;

import com.build.suchane.entity.Taluk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
@SpringBootApplication
public class SuchaneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuchaneApplication.class, args);
        System.out.println( new Taluk());
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
