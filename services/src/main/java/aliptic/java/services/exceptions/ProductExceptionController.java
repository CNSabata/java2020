package aliptic.java.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception) {
		return new ResponseEntity<>("Product [" + exception.getCode() + "] " + "not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InternalException.class)
	public ResponseEntity<Object> exception(InternalException exception) {
		return new ResponseEntity<>("Product INTERNAL ERROR : " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
