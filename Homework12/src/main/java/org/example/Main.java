package org.example;

import exceptions.BaggageTagPrintException;
import exceptions.FlightNotFoundException;
import exceptions.OverweightBaggageException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] flights = { "SU-123", "TK-777", "KC-909", "AE-404" };
        BaggageDropDesk desk_no1 = new BaggageDropDesk(flights);
        try {
            //  успешная сдача багажа
            //BaggageTicket ticket_no1 = desk_no1.checkBaggage("Василий Пяточкин", "SU-123", 10);
            //  указанного пассажиром рейса не существует в базе
            //BaggageTicket ticket_no2 = desk_no1.checkBaggage("Иван Добрый", "SU-124", 10);
            //  багаж слишком тяжелый
            //BaggageTicket ticket_no3 = desk_no1.checkBaggage("Анна Берёзова", "KC-909", 25);
            //  проблема с печатью бирки
            //BaggageTicket ticket_no4 = desk_no1.checkBaggage("Илья Весёлкин", "AE-404", 10);
            //  некорректное имя пассажира (null)
            //BaggageTicket ticket_no5 = desk_no1.checkBaggage(null, "SU-123", 10);
            //  некорректный вес багажа (отрицательный)
            BaggageTicket ticket_no6 = desk_no1.checkBaggage("Лёха Белый", "TK-777", -10);
        }
        catch (BaggageTagPrintException e) {
            System.out.println("Проверьте состояние принтера и напечатайте бирку ещё раз.");
        }
        catch (FlightNotFoundException e) {
            System.out.println("Проверьте корректность номера рейса.");
        }
        catch (OverweightBaggageException e) {
            System.out.println("Оплатите перевес багажа.");
        }

    }
}