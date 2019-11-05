package pl.booksagregator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiRequestNotFoundException.class)
    public ResponseEntity<Object> handleApiRequestNotFoundException(ApiRequestNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ApiException(e.getMessage(), httpStatus), httpStatus);
    }

    @ExceptionHandler(ApiRequestConflictException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestConflictException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        return new ResponseEntity<>(new ApiException(e.getMessage(), httpStatus), httpStatus);
    }

    @ExceptionHandler(ApiRequestForbiddenException.class)
    public ResponseEntity<Object> handleApiRequestForbiddenException(ApiRequestForbiddenException e) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(new ApiException(e.getMessage(), httpStatus), httpStatus);
    }

    @ExceptionHandler(ApiRequestUnauthorizedException.class)
    public ResponseEntity<Object> handleApiRequestUnauthorizedException(ApiRequestUnauthorizedException e) {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(new ApiException(e.getMessage(), httpStatus), httpStatus);
    }

}
