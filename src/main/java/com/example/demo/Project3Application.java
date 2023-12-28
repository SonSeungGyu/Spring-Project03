package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JPA 검사기능을 활성화하여 데이터가 생성 및 수정되는 것을 추적한다.
@EnableJpaAuditing
@SpringBootApplication
public class Project3Application {

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class, args);
	}

}
