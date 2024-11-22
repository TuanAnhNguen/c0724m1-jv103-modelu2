package case_study.model;

public class OfficialPhone extends Phone {
    private int warrantyPeriod;

    public OfficialPhone(int id, String namePhone, int price, int quantity, String manufacturer, int warrantyPeriod) {
        super(id, namePhone, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return "OfficialPhone{" + super.toString() +
                "warrantyPeriod=" + warrantyPeriod +
                '}';
    }

    public String dataToString() {
        return super.dataToString() + "," + warrantyPeriod;
    }
}
