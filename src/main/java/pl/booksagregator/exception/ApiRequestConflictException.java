package pl.booksagregator.exception;

public class ApiRequestConflictException extends RuntimeException {

    public ApiRequestConflictException(String message) {
        super(message);
    }
}
