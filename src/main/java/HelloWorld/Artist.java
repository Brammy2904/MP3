package HelloWorld;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer Id;

	@Column(name = "artistname")
	public String artistName;
	
	public void setId(Integer Id) {
		this.Id = Id;
	}

	public void setName(String artistName) {
		this.artistName = artistName;
	}
}
