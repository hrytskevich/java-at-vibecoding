package delivery.service;

import delivery.model.Parcel;

public class ParcelService {
    public void printParcelsReport(Parcel[] parcels) {
        for (int i = 0; i < parcels.length; i++) {
            parcels[i].printInfo();
            parcels[i].calculateDeliveryPrice();
            System.out.println();
        }
    }

}
