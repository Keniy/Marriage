package com.marriage.grapefruit;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot-MyBatis Application.
 *
 */
@ComponentScan(basePackages = "com.marriage.grapefruit")
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
    	ConfigurableApplicationContext run = run(Application.class, args);
//        SpringApplication.run(Application.class, args);
    }

}
