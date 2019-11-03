package pl.booksagregator.exception;

public class ApiRequestForbiddenException extends RuntimeException {
    public ApiRequestForbiddenException(String message) {
        super(message);
    }
}
