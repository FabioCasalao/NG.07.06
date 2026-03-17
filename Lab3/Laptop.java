public class Laptop extends ComputingEquipment {

    private int batteryLife;
    private double wigthKg;

    public Laptop(String name, double dailyPrice, String processor, int batteryLife, double wigthKg) {
        super(name, dailyPrice, processor);
        this.batteryLife = batteryLife;
        this.wigthKg = wigthKg;
    }

    // getters
    public int getBatteryLife() {
        return batteryLife;
    }

    public double getWigthKg() {
        return wigthKg;
    }

    // Setters
    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void setWigthKg(double wigthKg) {
        this.wigthKg = wigthKg;
    }

    @Override
    public String getEquipmentType() {
        return "Laptop";
    }

    @Override
    public double insuranceRate() {
        return 0.07;
    }

    @Override
    public String toString() {
        return super.toString() + ", batteryLife=" + batteryLife +
                ", wigthKg=" + wigthKg +
                '}';
    }
    
}
