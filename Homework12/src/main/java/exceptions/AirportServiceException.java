package exceptions;

public class AirportServiceException extends RuntimeException {
    public AirportServiceException(String message) {
        super(message);
    }
}
