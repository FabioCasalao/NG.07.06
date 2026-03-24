import java.util.ArrayList;
import java.util.List;

public class AppStart {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        System.out.println(mediaPlayer+"\n");

        StreamPlayer streamPlayer = new StreamPlayer();
        mediaPlayer = streamPlayer;
        System.out.println(streamPlayer+"\n");

        List<Podcast> podcasts = new ArrayList<>();
        
        podcasts.add(new Podcast("O Homem que mordeu o cão"));
        podcasts.add(new Podcast("O CEO é o limite"));
        podcasts.add(new Podcast("Portugalex"));

        // assign a podcast to the StreamPlayer and print whatsPlaying()
        streamPlayer.setPodcast(podcasts.get(0));
        System.out.println("whatsPlaying(): " + streamPlayer.whatsPlaying());

        LiveRadioPlayer liveRadioPlayer = new LiveRadioPlayer();
        mediaPlayer = liveRadioPlayer;
        System.out.println(liveRadioPlayer+"\n");

        List<Station> stations = new ArrayList<>();
        stations.add(new Station(88.3, "KFM"));
        stations.add(new Station(93.2, "RFM"));
        stations.add(new Station(95.7, "Antena 1"));
        stations.add(new Station(97.4, "Rádio Comercial"));
        stations.add(new Station(101.9, "Orbital"));

        liveRadioPlayer.increaseVolume();
        liveRadioPlayer.increaseVolume();
        liveRadioPlayer.increaseVolume();

        liveRadioPlayer.nextStation();
        System.out.println(liveRadioPlayer.whatsPlaying());
        liveRadioPlayer.nextStation();
        System.out.println(liveRadioPlayer.whatsPlaying());

        List<MediaPlayer> mediaPlayers = new ArrayList<>();
        mediaPlayers.add(mediaPlayer);
        mediaPlayers.add(streamPlayer);
        mediaPlayers.add(liveRadioPlayer);

        System.out.println("------------------------------------");

        for (MediaPlayer player : mediaPlayers) {
            System.out.println(player.whatsPlaying());
        }
    }
}
