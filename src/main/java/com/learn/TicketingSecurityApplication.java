package com.learn;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  //this includes @Configuration
public class TicketingSecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(TicketingSecurityApplication.class, args);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
