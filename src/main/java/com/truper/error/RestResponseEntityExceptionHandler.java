package com.truper.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.truper.error.beans.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
		// Error handle for RestResponseEntityExceptionHandler.class
		@ExceptionHandler(ListaCompraNotFoundException.class)
		public ResponseEntity<ErrorMessage> departmentNotFoundException(
				ListaCompraNotFoundException departmentNotFoundException, WebRequest request) {
			ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, departmentNotFoundException.getMessage());

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
}
