public class Equipment {
 
    private String id;
    private String name;
    private double dailyPrice;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public String getEquipmentType() {
        return "Equipment";
    }

    public double insuranceRate() {
        return 0.01;
    }

    public double calculateInsurance() {
        return dailyPrice * insuranceRate();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id.equals(equipment.id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return "Equipment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dailyPrice=" + dailyPrice +
                '}';
    }
}