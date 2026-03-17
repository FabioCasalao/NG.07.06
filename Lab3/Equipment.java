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
        return this.getClass().getSimpleName();
    }

    public Double insuranceRate() {
        return dailyPrice * 0.1;
    }

    public Double calculateInsurance() {
        return insuranceRate() * 30;
    }

    public Boolean equals(Equipment o) {
        return this.id.equals(o.id);
    }

    public Int hashCode() {
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