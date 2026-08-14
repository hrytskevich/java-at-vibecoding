package org.example;

public class BaggageTicket {
    private String passName;
    private String flightNumber;
    private int baggageWeight;

    public BaggageTicket(String passName, String flightNumber, int baggageWeight) {
        this.passName = passName;
        this.flightNumber = flightNumber;
        this.baggageWeight = baggageWeight;
    }

    public String getPassName() {
        return this.passName;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public int getBaggageWeight() {
        return this.baggageWeight;
    }

    @Override
    public String toString() {
        return "BaggageTicket{" +
                "passName='" + passName + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", baggageWeight=" + baggageWeight +
                '}';
    }
}
