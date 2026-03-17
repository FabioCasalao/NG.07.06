public class AudioVisualEquipment extends Equipment {
    String resolution;
    boolean isSmart;

    public AudioVisualEquipment(String name, double dailyPrice, String resolution, boolean isSmart) {
        super(name, dailyPrice);
        this.resolution = resolution;
        this.isSmart = isSmart;
    }

    @Override
    public String getEquipmentType() {
        return "AudioVisualEquipment";
    }

    @Override
    public double insuranceRate() {
        return 0.08;
    }

    @Override
    public String toString() {
        return super.toString() + ", resolution='" + resolution + '\'' +
                ", isSmart=" + isSmart +
                '}';
    }
}
