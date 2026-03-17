public class ComputingEquipment extends Equipment {

    private String processor;

    public String getProcessor() {
        return processor;
    }
    
    @Override
    public String toString() {
        return "ComputingEquipment{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", dailyPrice=" + getDailyPrice() +
                ", processor='" + processor + '\'' +
                '}';
    }
}
