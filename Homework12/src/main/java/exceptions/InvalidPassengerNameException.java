package exceptions;

public class InvalidPassengerNameException extends RuntimeException {
    public InvalidPassengerNameException(String message) {
        super(message);
    }
}
