package com.elpo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A implementação do commandlineRunner permite eu executar um comando quando o
 * spring iniciar
 * 
 * @author Alex
 *
 */
@SpringBootApplication
public class ElpoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElpoApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {		
	}

}
