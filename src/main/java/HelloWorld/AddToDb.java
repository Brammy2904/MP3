package HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AddToDb {
	@Autowired
	private ArtistRepository artistRep;
	
	@Autowired
	private TrackRepository trackRep;

public void initArtistExist(String artistName, Integer Id) {
	Artist artist1 = new Artist();
	artist1.setId(Id);
	artist1.setName(artistName);
	artistRep.save(artist1);
}
public void initArtistNew(String artistName) {
	Artist artist1 = new Artist();
	artist1.setName(artistName);
	artistRep.save(artist1);
}
public void initTrack(String trackName, String trackURL, String imgURL, String artistName, Integer Id, double duration) {
	Track track1 = new Track();
	track1.setName(trackName);
	track1.setURL(trackURL);
	track1.setImg(imgURL);
	track1.setArtistId(Id);
	track1.setDur(duration);
	trackRep.save(track1);
}

}
