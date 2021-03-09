package adapter;

public class AudioPlayer implements MediaPlayer{
    Adapter adapter = new VideoPlayer();

    @Override
    public void play(String name) {
        if(name.endsWith("mkv")) {
            adapter.play(name);
        } else {
            System.out.println("playing music");
        }
    }
}
