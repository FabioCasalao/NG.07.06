import java.util.List;

public class LiveRadioPlayer extends MediaPlayer {
    private List<Station> stationList;
    private Station currentStation;

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(Station currentStation) {
        this.currentStation = currentStation;
    }

    public void nextStation() {
        int currentIndex = stationList.indexOf(currentStation);
        if (currentIndex < stationList.size() - 1) {
            currentStation = stationList.get(currentIndex + 1);
        } else {
            currentStation = stationList.get(0); // Loop back to the first station
        }
    }

    public void previousStation() {
        int currentIndex = stationList.indexOf(currentStation);
        if (currentIndex > 0) {
            currentStation = stationList.get(currentIndex - 1);
        } else {
            // already at first station -- do nothing
        }
    }

    public LiveRadioPlayer() {
        super();
        this.stationList = List.of(
            new Station(103.4, "Renanscença"),
            new Station(104.7, "Band FM"),
            new Station(105.9, "Jovem Pan")
        );
        this.currentStation = stationList.get(0); // Default to the first station
    }

    @Override
    public String whatsPlaying() {
        return "Live Radio Player: " + currentStation.getFrequency() + ": " + currentStation.getName();
    }
}
