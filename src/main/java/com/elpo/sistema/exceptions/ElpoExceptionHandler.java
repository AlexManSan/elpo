package com.elpo.sistema.exceptions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Manipulador de evenvos de erros + envio de mensagem para o usuário e para o desenvolvedor
 * @author Alex
 *
 */
@ControllerAdvice // observa toda a aplicação
public class ElpoExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Erro de Mensagem não legivel
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		// lendo a mesnagem do arquivo messages.properties
		String msgUser = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String msgDev = ex.getCause().toString();
		
		// transformando o 1 objeto em lista pra retornar em lista pra ficar padrão para qualquer erro
		List<ErroMsg> erros = Arrays.asList(new ErroMsg(msgUser, msgDev));
		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	/**
	 * Erro de argumento não válido no caso o bean validation da classe model
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ErroMsg> erros = criarListaDeErros(ex.getBindingResult());
		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	// tratando exceptions diferentes
	/**
	 * Posso querer retornar alguma mensagem caso eu queira fazer as mensgens igual ao primeiro método
	 * protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
	 * @param ex
	 */
	@ExceptionHandler({EmptyResultDataAccessException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	public void handleEmptyResultDataAccessException(RuntimeException ex) { }
	
	@ExceptionHandler({NonUniqueResultException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	public void handleNonUniqueResultException(RuntimeException ex) { }
	
	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	public void handleConstraintViolationException(RuntimeException ex) { }
	
	/**
	 * cria uma lista com erros de cada atributo da classe 
	 * eu capturo a lista com os erros no BindingResult
	 * @return
	 */
	private List<ErroMsg> criarListaDeErros(BindingResult bindResult){
		List<ErroMsg> erros = new ArrayList<>();
		
		// varrendo a lista de erro recebida field = campos atributos
		for(FieldError fieldError : bindResult.getFieldErrors()) {
			
			String msgUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String msgDev = fieldError.toString();
			
			erros.add(new ErroMsg(msgUser, msgDev));
		}
		return erros;
	}
	
	/**
	 * Pra enviar as mensagens de usuario e desenvolvedor separadas
	 * essa é uma classe que so será utilizada aqui dentro desta outra classe ElpoExceptionHandler
	 */
	public static class ErroMsg{
		private String msgUser;
		private String msgDev;
		
		/**
		 * Método construtor
		 * @param msgUser
		 * @param msgDev
		 */
		public ErroMsg(String msgUser, String msgDev) {
			this.msgUser = msgUser;
			this.msgDev = msgDev;
		}

		public String getMsgUser() {
			return msgUser;
		}

		public String getMsgDev() {
			return msgDev;
		}	
		
	}

}
