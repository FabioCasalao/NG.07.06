public class Desktop extends ComputingEquipment {

    private String brand;

    public Desktop(String name, String brand, String processor, double dailyPrice) {
        super(name, dailyPrice, processor);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getEquipmentType() {
        return "Desktop";
    }

    @Override
    public double insuranceRate() {
        return 0.06;
    }

    @Override
    public String toString() {
        return super.toString() + ", brand='" + brand + '\'' +
                '}';
    }
}
