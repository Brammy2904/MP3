package HelloWorld;

import org.springframework.stereotype.Service;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

@Service
public class PlaySound {
	int playing = 0;
	MediaPlayer mediaPlayer;
	String filetest;

	public PlaySound() {
		com.sun.javafx.application.PlatformImpl.startup(() -> {
		});
	}

	public void makePlayer(String file, Double volume) {
		int temp = (int) (volume * 100.0);
		double volum = ((double) temp) / 100.0;
		if (mediaPlayer != null && filetest.contentEquals(file)) {
			mediaPlayer.setVolume(volum);
			mediaPlayer.play();
		} else {
			try {

				Media hit = new Media(file);
				mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.play();
				mediaPlayer.setVolume(volum);
				filetest = file;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void pause() {

//		Media hit = new Media(file);
//		mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.pause();
		Status status = mediaPlayer.getStatus();
	}

}
