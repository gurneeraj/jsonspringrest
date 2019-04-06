package com.amreen.jsonproject.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author gurneerajsinghdahele
 *
 */
@ControllerAdvice
public class ApplicationRestExceptionHandler{
	
	
	/**
	 * This method catches all exceptions except MethodArgumentNotValidException
	 * @param exc is of exception type
	 * @return ResponseEntity<ApplicationErrorResponse> with error details
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApplicationErrorResponse> handleException(Exception exc) {
		
		ApplicationErrorResponse error = new ApplicationErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles exceptions of MethodArgumentNotValidException type and returns validation errors
	 * @param ex is of MethodArgumentNotValidException type
	 * @return ResponseEntity<Object> 
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
	
		//This method loops through the validation errors and returns to the client
		Map<String, String> errors = new LinkedHashMap<>();
		errors.put("status", "400");
		List<ObjectError> fieldErrors = ex.getBindingResult().getAllErrors();
		for(int index = 0; index < fieldErrors.size(); index++) {
	        String fieldName = ((FieldError) fieldErrors.get(index)).getField();
	        String errorMessage = fieldErrors.get(index).getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    }
		
		errors.put("timestamp", Long.toString(System.currentTimeMillis()));
		
		// return ResponseEntity
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
