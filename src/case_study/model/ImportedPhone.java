package case_study.model;

public class ImportedPhone extends Phone {
    private String country;

    public ImportedPhone(int id, String namePhone, int price, int quantity, String manufacturer, String country) {
        super(id, namePhone, price, quantity, manufacturer);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ImportedPhone{" + super.toString() +
                "country='" + country + '\'' +
                '}';
    }

    public String dataToString() {
        return super.dataToString() + "," + country;
    }
}
