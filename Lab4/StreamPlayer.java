
class StreamPlayer extends MediaPlayer {
    private Podcast podcast;

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }

    public StreamPlayer() {
        super();
        this.podcast = new Podcast("No Podcast"); // default Podcast
    }

    @Override
    public String whatsPlaying() {
        return "Playing podcast: " + podcast.getTitle();
    }
}
