import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String addressline;
    private String city;
    private String state;
    private int pincode;

    public void setAdd(String addressline) {
        this.addressline = addressline;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getAdd() {
        return addressline;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "add='" + addressline + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
