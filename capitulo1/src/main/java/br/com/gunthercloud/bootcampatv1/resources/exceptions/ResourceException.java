package br.com.gunthercloud.bootcampatv1.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.gunthercloud.bootcampatv1.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceException {
	
	@ExceptionHandler
	public ResponseEntity<StandardError> notFound(ResourceNotFoundException e, HttpServletRequest request) {
		StandardError obj = new StandardError();
		obj.setStatus(HttpStatus.NOT_FOUND.value());
		obj.setError("Not Found");
		obj.setMessage(e.getMessage());
		obj.setTimestamp(Instant.now());
		obj.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
	}

}
