package com.deepali.blogapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.deepali.blogapp.config.modelMapper;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BlogAppApplication.class, args);
		context.getBean(modelMapper.class);
	
	}


	}
