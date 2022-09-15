package com.sakila.api.sakilaapp;

import com.sakila.api.sakilaapp.Helpers.ModelMapperHelper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@CrossOrigin
public class SakilaAppApplication {

	@Bean
	public ModelMapperHelper modelMapperHelper() {
		return new ModelMapperHelper(new ModelMapper());
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaAppApplication.class, args);
	}

}
