package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }


    @Bean
    WebMvcConfigurer WebMvcConfigurerAdapter() {
        return new WebMvcConfigurerAdapter(){
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry
                        .addResourceHandler("/webjars/** ** ")
                        .addResourceLocations("/webjars/");
            }
        };
    }

}