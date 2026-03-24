public class MediaPlayer {
  
    private int volume;
    private boolean muted;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            this.volume = 0;
        } else if (volume > 10) {
            this.volume = 10;
        } else {
            this.volume = volume;
        }
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }
    
    public MediaPlayer() {
        this.volume = 5; // Default volume level
        this.muted = false; // Not muted by default
    }

    public void increaseVolume() {
        if (!muted && volume < 10) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (!muted && volume > 0) {
            volume--;
        }
    }

    public String whatsPlaying(){
        return "Nothing to play.";
    }

    public String toString() {
        return "Volume : " + volume + "\n" + whatsPlaying();
    }

}
