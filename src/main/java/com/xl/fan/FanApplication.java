package com.xl.fan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FanApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanApplication.class, args);
    }

}
