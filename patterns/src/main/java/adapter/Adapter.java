package adapter;

import java.io.File;

/**
 * Соединяет несовместимые интерфейсы
 * адаптер реализует интерфейс, а аудиоплэйер использует адаптер.
 * Аудиоплейер не знает про реализацию адаптера.
 * можно сделать через наследование, так будет ясней
 */
public class Adapter implements MediaPlayer {

    VideoPlayer videoPlayer = new VideoPlayer();
    @Override
    public void play(String name) {
        videoPlayer.playVideo(new File(name));
    }
}
