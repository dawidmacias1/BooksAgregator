package pl.booksagregator.exception;

public class ApiRequestNotFoundException extends RuntimeException {

    public ApiRequestNotFoundException(String message) {
        super(message);
    }
}
