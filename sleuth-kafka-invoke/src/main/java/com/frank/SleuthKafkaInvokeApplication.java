package com.frank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:50 2018-12-29
 * @ Description：
 * @ Modified By：
 */
@RestController
@SpringBootApplication
public class SleuthKafkaInvokeApplication {
    @Value("${spring.application.name}")
    private String serverName;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String getHelloWorld(){
        System.out.println(serverName);
        String backendBaseUrl = System.getProperty("spring.example.backendBaseUrl", "http://localhost:8004");
        return restTemplate.getForObject(backendBaseUrl+"/test",String.class);
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/test2")
    public String test2(){
        System.out.println("CCCCCCCCCCCCCCCCCC");
        return serverName+": hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SleuthKafkaInvokeApplication.class,args);
    }
}
