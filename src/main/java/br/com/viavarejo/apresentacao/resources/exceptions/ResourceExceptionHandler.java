package br.com.viavarejo.apresentacao.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.viavarejo.apresentacao.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
		
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Objeto não encontrado", e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(httpStatus).body(err);
		
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<StandardError> httpRequestMethodNotSuportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest req) {
		
		HttpStatus httpStatus = HttpStatus.METHOD_NOT_ALLOWED;
		StandardError err = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Método não permitido", e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(httpStatus).body(err);
		
	}
	
}
