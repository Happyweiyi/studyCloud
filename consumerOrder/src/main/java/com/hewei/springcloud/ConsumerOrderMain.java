package com.hewei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrderMain {

    public static void main(String args[]){
        SpringApplication.run(ConsumerOrderMain.class,args);
    }
}
