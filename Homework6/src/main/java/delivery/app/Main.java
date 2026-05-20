package delivery.app;

import delivery.model.ExpressParcel;
import delivery.model.FragileParcel;
import delivery.model.Parcel;
import delivery.service.ParcelService;

public class Main {
    public static void main(String[] args) {
        Parcel parcel1 = new Parcel("Весенний Игорь Петрович", "г. Цветочный, ул. Майская, д. 5", 1.25, "7DASD-U8O4-12D356");
        FragileParcel fragileParcel = new FragileParcel("Летний Иван Андреевич", "г. Солнечный, ул. Июльская, д. 7", 0.14, "5DASD-T5B6-85N253", true);
        ExpressParcel expressParcel = new ExpressParcel("Осенний Виктор Сергеевич", "г. Дождливый, ул. Октябрьская, д. 4", 2.5, "3DASD-V3C4-85A198", 10);
        Parcel parcel2 = new Parcel();
        parcel2.setRecipientName("Зимний Роман Дмитриевич");
        parcel2.setDeliveryAddress("г. Снежный, ул. Январская, д. 1");
        parcel2.setParcelWeight(0.98);

        Parcel parcels[] = {parcel1, fragileParcel, expressParcel, parcel2};

        ParcelService parcelService = new ParcelService();
        parcelService.printParcelsReport(parcels);
    }
}
