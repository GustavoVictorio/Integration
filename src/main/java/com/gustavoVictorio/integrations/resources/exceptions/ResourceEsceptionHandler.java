package com.gustavoVictorio.integrations.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gustavoVictorio.integrations.services.exceptions.EmailException;

@ControllerAdvice
public class ResourceEsceptionHandler {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<StandardError> email(EmailException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimeStamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Email error");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
