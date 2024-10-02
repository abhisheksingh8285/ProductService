package dev.abhi.productserviceaug.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class
ApplicationConfrigation {


    @Bean
    public RestTemplate createRestTemplate ()
    {
        return new RestTemplate();
    }
}
