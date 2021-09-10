package br.com.viavarejo.apresentacao.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
}
