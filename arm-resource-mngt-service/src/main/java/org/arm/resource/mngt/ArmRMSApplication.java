package org.arm.resource.mngt;

import org.arm.resource.mngt.impl.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ArmRMSApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArmRMSApplication.class, args);
	}

	@Autowired
	IProjectService projectService;
	@Override
	public void run(String... args) throws Exception {
	System.out.println("prinbtinggggshcvshcjsdvcj");
		projectService.getAllProject().forEach(System.out::println);
	}
}
