public class AudioVisualEquipment extends Equipment {
    String resolution;
    boolean isSmart;

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
