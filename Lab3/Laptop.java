public class Laptop extends ComputingEquipment {

    private int batteryLife;
    private double wigthKg;

    public int getBatteryLife() {
        return batteryLife;
    }

    public double getWigthKg() {
        return wigthKg;
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
