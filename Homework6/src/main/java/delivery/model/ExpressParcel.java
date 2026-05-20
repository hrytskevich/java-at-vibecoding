package delivery.model;

public class ExpressParcel extends Parcel {
    private int deliveryHours;

    public ExpressParcel(String recipientName, String deliveryAddress, double parcelWeight, String trackingCode, int deliveryHours) {
        super(recipientName, deliveryAddress, parcelWeight, trackingCode);
        this.deliveryHours = deliveryHours;
    }

    public double calculateDeliveryPrice() {
        if (deliveryHours < 24) {
            return super.calculateDeliveryPrice() + 500;
        }
        return super.calculateDeliveryPrice();
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Срок доставки: " + deliveryHours + " дней");
    }
}
