package delivery.model;

public class Parcel {
    private String recipientName;
    private String deliveryAddress;
    protected double parcelWeight;
    private String trackingCode;

    public Parcel (String recipientName, String deliveryAddress, double parcelWeight, String trackingCode) {
        this.recipientName = recipientName;
        this.deliveryAddress = deliveryAddress;
        this.parcelWeight = parcelWeight;
        this.trackingCode = trackingCode;
    }

    public Parcel() {
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(double parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public double calculateDeliveryPrice() {
        return (100 + parcelWeight * 30);
    }

    public void printInfo() {
        System.out.println("Имя получателя: " + recipientName);
        System.out.println("Адрес доставки: " + deliveryAddress);
        System.out.println("Вес посылки: " + parcelWeight + " кг");
        System.out.println("Трек-номер: " + ((trackingCode != null) ? trackingCode : "отсутствует, свяжитесь с почтовым отделением"));
    }
}
