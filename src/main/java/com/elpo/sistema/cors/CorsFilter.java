package com.elpo.sistema.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Não mconsegui fazer funcionar direito
 * @author Alex
 *
 */

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE) // ordem de prioridade alta
public class CorsFilter implements Filter {

	private String originPermitida = "http://localhost:8100";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Convertendo servletRequest e servletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
//		resp.setHeader("access-Control-Allow-Origin", originPermitida);
		resp.setHeader("access-Control-Allow-Origin", "*");
//		resp.setHeader("access-Control-Allow-Credentials", "true");
		
		// permitindo tudo para o origin permitida
//		if(originPermitida.equals(req.getHeader("Origin"))) {
			
			resp.setHeader("access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			resp.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//        	resp.setHeader("Access-Control-Max-Age", "3600");
        	
        	resp.setStatus(HttpServletResponse.SC_OK);
//		}else {
//			chain.doFilter(request, response);
//		}
	}

}
