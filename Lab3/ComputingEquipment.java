public class ComputingEquipment extends Equipment {

    private String processor;

    public String getProcessor() {
        return processor;
    }
    
    @Override
    public String getEquipmentType() {
        return "ComputingEquipment";
    }

    @Override
    public double insuranceRate() {
        return 0.05;
    }

    @Override
    public String toString() {
        return super.toString() + ", processor='" + processor + '\'' +
                '}';
    }
}