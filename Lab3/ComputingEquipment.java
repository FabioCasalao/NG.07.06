public class ComputingEquipment extends Equipment {

    private String processor;

    public ComputingEquipment(String name, double dailyPrice, String processor) {
        super(name, dailyPrice);
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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