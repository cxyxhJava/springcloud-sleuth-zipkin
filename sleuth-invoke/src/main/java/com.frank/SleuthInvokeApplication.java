package com.frank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:50 2018-12-29
 * @ Description：
 * @ Modified By：
 */
@RestController
@SpringBootApplication
public class SleuthInvokeApplication {
    @Value("${spring.application.name}")
    private String serverName;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String getHelloWorld(){
        System.out.println("AAAAAAAAAAAAAAAAAAA");
        String backendBaseUrl = System.getProperty("spring.example.backendBaseUrl", "http://localhost:8002");
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

//    @Autowired
//    private LoadBalancerExchangeFilterFunction lbFunction;
//
//    @Bean
//    public WebClient webClient() {
//        return WebClient.builder().baseUrl("http://sleuth-provide")
//                .filter(lbFunction)
//                .build();
//    }
//
//    @GetMapping("/sleuth-invoke")
//    public Mono<String> trace() {
//        System.out.println("===call trace-a===");
//
//        return webClient().get()
//                .uri("/trace")
//                .retrieve()
//                .bodyToMono(String.class);
//    }


    public static void main(String[] args) {
        SpringApplication.run(SleuthInvokeApplication.class,args);
    }
}
