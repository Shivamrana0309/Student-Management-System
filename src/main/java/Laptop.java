import jakarta.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;
    private String brand;
    private String model;
    private String ram;
    private int price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getLid() {
        return lid;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getRam() {
        return ram;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram='" + ram + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
