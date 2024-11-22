package case_study.model;

import java.util.Objects;

public abstract class Phone {
    private int id;
    private String namePhone;
    private int price;
    private int quantity;
    private String manufacturer;

    public Phone(int id, String namePhone, int price, int quantity, String manufacturer) {
        this.id = id;
        this.namePhone = namePhone;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", namePhone='" + namePhone + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone phone)) return false;
        return id == phone.id && price == phone.price && quantity == phone.quantity && Objects.equals(namePhone, phone.namePhone) && Objects.equals(manufacturer, phone.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namePhone, price, quantity, manufacturer);
    }

    public String dataToString() {
        return id + "," + namePhone + "," + price + "," + quantity + "," + manufacturer;
    }
}
