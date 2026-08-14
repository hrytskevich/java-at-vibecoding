package exceptions;

public class FlightNotFoundException extends AirportServiceException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}
