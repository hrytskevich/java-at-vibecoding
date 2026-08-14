package exceptions;

public class OverweightBaggageException extends AirportServiceException {
    public OverweightBaggageException(String message) {
        super(message);
    }
}
