package org.recruitment.problem.transfer.api.exception.handler;

import javax.validation.ConstraintViolationException;

import org.recruitment.problem.transfer.api.exception.AccountNotActiveException;
import org.recruitment.problem.transfer.api.exception.AccountNotFoundException;
import org.recruitment.problem.transfer.api.exception.InsufficentFundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TransferServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundExceptionHandler(AccountNotFoundException ex, WebRequest request)
	        throws Exception {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(InsufficentFundException.class)
	public ResponseEntity<Object> insufficentFundExceptionHandler(InsufficentFundException ex, WebRequest request)
	        throws Exception {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(AccountNotActiveException.class)
	public ResponseEntity<Object> accountNotActiveExceptionHandler(AccountNotActiveException ex, WebRequest request)
	        throws Exception {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> customExceptionHandler(ConstraintViolationException ex, WebRequest request)
	        throws Exception {
		return ResponseEntity.badRequest()
		        .body(ex.getConstraintViolations().stream().map(a -> a.getMessageTemplate()).findAny());
	}
}
