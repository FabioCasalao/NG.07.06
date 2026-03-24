import java.util.ArrayList;
import java.util.List;

public class AppStart {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        System.out.println(mediaPlayer+"\n");

        StreamPlayer streamPlayer = new StreamPlayer();
        System.out.println(streamPlayer+"\n");

        List<Podcast> podcasts = new ArrayList<>();
        
        podcasts.add(new Podcast("O Homem que mordeu o cão"));
        podcasts.add(new Podcast("O CEO é o limite"));
        podcasts.add(new Podcast("Portugalex"));

        // assign a podcast to the StreamPlayer and print whatsPlaying()
        streamPlayer.setPodcast(podcasts.get(0));
        System.out.println("whatsPlaying(): " + streamPlayer.whatsPlaying());


    }
}
