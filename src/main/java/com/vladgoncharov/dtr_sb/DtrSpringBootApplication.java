package com.vladgoncharov.dtr_sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DtrSpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DtrSpringBootApplication.class, args);

        //подключение к бд с помощью ssl
        System.setProperty("javax.net.ssl.trustStore", "/path/to/root.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "83988398veyvik87");
    }

}
