package com.scholara.scholara;

import org.springframework.boot.SpringApplication;

public class TestScholaraApplication {

	public static void main(String[] args) {
		SpringApplication.from(ScholaraApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
