package HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HtmlContoller {
	@Autowired
	private ArtistRepository artistRep;
	
	@Autowired
	private TrackRepository trackRep;
	
	@GetMapping("/add")
	public String add() {
		return "Add";
	}
	@GetMapping("/home")
	public String home() {
		return "MP3";
	}
	
}
