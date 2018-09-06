package com.leonardomota.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leonardomota.cursomc.services.DBService;
import com.leonardomota.cursomc.services.EmailService;
import com.leonardomota.cursomc.services.MockMailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatavase();		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockMailService();
	}
	
}
