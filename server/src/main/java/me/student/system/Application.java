package me.student.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	// TODO: Add Pagination, Data Transfer Objects, 2FA, Email Service for registration & Protected Routes

}
