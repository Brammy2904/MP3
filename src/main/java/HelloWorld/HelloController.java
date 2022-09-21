package HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.sapher.youtubedl.YoutubeDLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelloController {
	double duration = 0;

	@Autowired
	private ArtistRepository artistRep;

	@Autowired
	private TrackRepository trackRep;
	

	@Autowired
	private AddToDb add;
	@Autowired
	public PlaySound player;


	@GetMapping("/getTrack")
	public Iterable<Track> findTrackByName(@RequestParam(required = false) String trackName) {

		return trackRep.findTrack(trackName);
	}
	
	@GetMapping("/data")

	public void add(@RequestParam(required = false) String trackName, @RequestParam(required = false) String trackURL,
			@RequestParam(required = false) String imgURL, @RequestParam(required = false) String artistName )
			throws MalformedURLException, IOException, InterruptedException, YoutubeDLException {
		if (trackName != null && trackURL != null && imgURL != null && artistName != null) {
			Thread.sleep(10000);
			String bip = trackURL;
			String file = new File(bip).toURI().toString();
			Media hit = new Media(file);
			MediaPlayer mediaPlayer = new MediaPlayer(hit);

			mediaPlayer.statusProperty().addListener((obs, oldStatus, newStatus) -> {
				if (newStatus == MediaPlayer.Status.READY) {

					duration = mediaPlayer.getTotalDuration().toSeconds();

					add.initArtistNew(artistName);
					Integer ArId = artistRep.findLastId();

					add.initTrack(trackName, trackURL, imgURL, artistName, ArId, duration);
					System.out.println("Added: " + trackName);
				}
			});

		}
	}

	@GetMapping("/change")
	public void change(@RequestParam(required = false) double time) {
		Double test = time;
		if (test != null) {
			player.mediaPlayer.seek(Duration.seconds(time));
		}
	}

	@GetMapping("/volume")
	public void volum(@RequestParam(required = false) Double volume) {

		if (volume != null && player.mediaPlayer != null) {
//double vo = 0.1;
			int temp = (int) (volume * 100.0);
			double volum = ((double) temp) / 100.0;
			player.mediaPlayer.setVolume(volum);

		}
	}

	@GetMapping("/getRunTime")
	public double getTime() {
		double time = 0.000;
		if (player.mediaPlayer != null) {

			time = player.mediaPlayer.getCurrentTime().toSeconds();
		}
		return time;
	}

	@Scheduled(fixedRate = 3000)
	public void schedule() {
		getTime();
	}

	@GetMapping("/artist")
	public Iterable<Artist> index() {
		return artistRep.findAll();
	}

	@GetMapping("/track")
	public Iterable<Track> index1() {
		return trackRep.getAllTracks();
	}
	
	@GetMapping("/addPlaylist")
	public Track addPlaylist(@RequestParam(required = false) String trackName) {
		return trackRep.findURL(trackName);
		
		
//		add.initPlaylist(trackName, track1.trackURL, track1.imgURL, track1.duration, track1.artistId);
	}

	@GetMapping("/Control")
	public void control(@RequestParam(required = false) String action,
			@RequestParam(required = false) String trackName, @RequestParam(required = false) Double volume) {

		if (action != null) {

			Track track1 = trackRep.findURL(trackName);
			String trackURL = track1.trackURL;

			if (action.contentEquals("play")) {
				String bip = trackURL;
				String file = new File(bip).toURI().toString();
				player.makePlayer(file, volume);
				

			}
			if (action.contentEquals("pause")) {
				player.pause();
			}
		}
	}

}
