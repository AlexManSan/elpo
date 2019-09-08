package com.elpo.sistema.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elpo.sistema.event.RecursoCriadoEvent;

/**
 * E o cara que ouve/escuta o evento informando qual evento ele quer ouvir para ele executar alguma coisa
 * 
 * OBS: posso implementar outros listener para outros eventos 
 * @author Alex
 *
 */
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {
		HttpServletResponse response = event.getResponse();
		Long id = event.getId();
		
		AdicionarHeaderLocation(response, id);
		
	}

	/**
	 * Metodo privado criado para adicionar o header location ao executador de eventos  
	 * @param response
	 * @param id
	 */
	private void AdicionarHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(id)
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
