package com.pupil.technicaltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShapeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShapeApplication.class, args);
    }

}
