import java.util.Objects;

public class Equipment {
 
    private String id;
    private String name;
    private double dailyPrice;

    public Equipment(String name, double dailyPrice) {
        this.name = name;
        this.dailyPrice = dailyPrice;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
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
        if (id != null && equipment.id != null) {
            return id.equals(equipment.id);
        }
        return Objects.equals(name, equipment.name);
    }

    public int hashCode() {
        return id != null ? id.hashCode() : Objects.hashCode(name);
    }

    public String toString() {
        return "Equipment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dailyPrice=" + dailyPrice +
                '}';
    }
}