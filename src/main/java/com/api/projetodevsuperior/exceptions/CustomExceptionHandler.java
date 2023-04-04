package com.api.projetodevsuperior.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.projetodevsuperior.exceptions.custom.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException exception, HttpServletRequest request) {
		ApiErrorMessage apiErrorMessage = new ApiErrorMessage(Instant.now(), HttpStatus.NOT_FOUND.value(), "User was not found",
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
	}
}
