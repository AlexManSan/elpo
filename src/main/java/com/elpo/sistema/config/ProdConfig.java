package com.elpo.sistema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Classe responsável por carregar as informações do arquivo de persistência application-prod.properties
 * @author Alex
 *
 */
@Configuration
@Profile("prod")
public class ProdConfig {

	/**
	 * Por ser a implementação prod neste método eu informo qual Classe será implementada o emailService
	 * @return
	 */
//	@Bean
//	public EmailService emailService() {
//		return new SmtpEmailService();
//	}
}
