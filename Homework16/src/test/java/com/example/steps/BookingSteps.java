package com.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;

import java.util.List;
import java.util.Map;

public class BookingSteps {
    @Дано("в ресторане есть столики")
    public void setTables(DataTable table) {
        List<Map<String, String>> rows = table.asMaps();
        System.out.println("\nСтолики ресторана:");
        for(Map<String, String> row: rows) {
            int number = Integer.parseInt(row.get("номер"));
            int capacity = Integer.parseInt(row.get("вместимость"));
            System.out.printf("Столик №%d вмещает %d чел.", number, capacity);
            System.out.println();
        }
        //throw new io.cucumber.java.PendingException();
    }

    @Дано("^все столики (забронированы|свободны)$")
    public void makeAllTablesBookedOrFree(String status) {
        System.out.println();
        System.out.printf("Все столики %s", status);
        //throw new io.cucumber.java.PendingException();
    }

    @Дано("^сделать столик под номером (\\d+) (свободным|забронированным)$")
    public void makeTableBookedOrFree(int tableNumber, String status) {
        System.out.println();
        System.out.printf("Столик №%d с вместимостью %d чел. является %s", tableNumber, tableNumber, status);
        //throw new io.cucumber.java.PendingException();
    }

    @Когда("^клиент бронирует столик для (\\d+) гостей на (\\d+) (?:час|часа|часов) с пожеланием \"([^\"]*)\"$")
    public void bookTableWithPreference(int guests, int hours, String preference) {
        System.out.println();
        System.out.printf("Клиент хочет забронировать столик на %d чел. на %d ч. с пожеланием %s", guests, hours, preference);
        //throw new io.cucumber.java.PendingException();
    }

    @Когда("^клиент бронирует столик для (\\d+) гостей на (\\d+) (?:час|часа|часов) без пожелания$")
    public void bookTableWoPreference(int guests, int hours) {
        System.out.println();
        System.out.printf("Клиент хочет забронировать столик на %d чел. на %d ч. без пожелания", guests, hours);
        //throw new io.cucumber.java.PendingException();
    }

    @Когда("клиент отменяет бронь столика под номером {int}")
    public void cancelBooking(int tableNumber) {
        System.out.println();
        System.out.printf("Клиент хочет отменить бронь столика №%d", tableNumber);
        //throw new io.cucumber.java.PendingException();
    }

    @Когда("клиент оставляет пожелание к брони")
    public void addPreference(String preference) {
        System.out.println();
        System.out.printf("Клиент хочет оставить пожелание: %s", preference);
    }

    @То("^столик под номером (\\d+) имеет статус \"(Забронирован|Свободен)\"$")
    public void checkTableStatus(int tableNumber, String tableStatus) {
        System.out.println();
        System.out.printf("Столик №%d имеет статус %s", tableNumber, tableStatus);
        //throw new io.cucumber.java.PendingException();
    }

    @То("^отображается сообщение \"([^\"]*)\"$")
    public void checkMessage(String message) {
        System.out.println();
        System.out.printf("Сообщение клиенту: %s", message);
        //throw new io.cucumber.java.PendingException();
    }

    @То("^клиент получает статус брони \"(Принята|Отказ|Отменена)\"$")
    public void getBookingStatus(String bookingStatus) {
        System.out.println();
        System.out.printf("Статус брони: %s", bookingStatus);
    }
}
