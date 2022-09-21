package HelloWorld;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="track")
public class Track {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trackid")
	public Integer trackId;
	@Column(name="trackname")
	public String trackName;
	@Column(name="trackURL")
	public String trackURL;
	@Column(name="imgURL",columnDefinition = "LONGTEXT")
	public String imgURL;
	@Column(name="artistid")
	public Integer artistId;
	@Column (name="duration")
	public double duration;
	
	public void setName(String trackName) {
		this.trackName = trackName;
	}
	public void setURL(String trackURL) {
		this.trackURL = trackURL;
	}
	public void setImg(String imgURL) {
		this.imgURL = imgURL;
	}
	public void setDur(double duration) {
		this.duration = duration;
	}
	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
}
