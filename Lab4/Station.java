public class Station {
    
    private double frequency;
    private String name;

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Station(double frequency, String name) {
        this.frequency = frequency;
        this.name = name;
    }
}
