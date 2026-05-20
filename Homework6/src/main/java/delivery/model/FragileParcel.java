package delivery.model;

public class FragileParcel extends Parcel {
    private boolean requiresCarefulHandling;

    public double calculateDeliveryPrice() {
        return super.calculateDeliveryPrice() + 200;
    }

    public FragileParcel(String recipientName, String deliveryAddress, double parcelWeight, String trackingCode, boolean requiresCarefulHandling) {
        super(recipientName, deliveryAddress, parcelWeight, trackingCode);
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Обращаться с осторожностью (хрупкое): " + (requiresCarefulHandling ? "Да" : "Нет"));
    }
}
