/**
 * 
 */
package com.meili.carfleet.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.meili.carfleet.models.ErrorResponse;

/**
 * @author LAIJU It is designed to handle the specific exception
 *         globally and respond with a standardized error
 *         message and HTTP status code (404 Not Found).
 * 
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private ErrorResponse errorResponse;

	@ExceptionHandler(NoRecordFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse handleException(Exception e) {
		errorResponse.setStatusCode("500");
		errorResponse.setMessage("Internal Server Error");
		return errorResponse;
	}

}
