package org.example;

import exceptions.*;

import java.util.Arrays;

public class BaggageDropDesk {
    public String[] flights;

    public BaggageDropDesk(String[] flights) {
        this.flights = flights;
    }

    public BaggageTicket checkBaggage(String passName, String flightNumber, int baggageWeight) {
        if (passName == null || passName == "")
            throw new InvalidPassengerNameException("Отсутствует имя пассажира!");
        if (baggageWeight < 0)
            throw new InvalidBaggageWeightException("Вес багажа не может быть меньше нуля!");
        if (!Arrays.asList(flights).contains(flightNumber))
            throw new FlightNotFoundException("Указанного рейса нет в списке доступных рейсов");
        if (baggageWeight > 23)
            throw new OverweightBaggageException("Вес багажа больше 23 кг!");
        if (flightNumber.equals("AE-404"))
            throw new BaggageTagPrintException("Возникла проблема при печати багажной бирки");

        System.out.println("Клиент должен уплатить налог за слишком правильные введённые данные!");
        return new BaggageTicket(passName, flightNumber, baggageWeight);
    }
}
