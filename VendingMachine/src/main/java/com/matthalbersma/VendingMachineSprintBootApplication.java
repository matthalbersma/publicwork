package com.matthalbersma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
public class VendingMachineSprintBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendingMachineSprintBootApplication.class, args);
	}
//        //@Override
//        public void addViewControllers(ViewControllerRegistry registry) {
//            registry.addViewController("/login").setViewName("login");
//        }


}