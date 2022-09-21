package HelloWorld;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends CrudRepository<Track, Integer> {
	@Query(value = "Select * from track t ORDER BY t.trackName", nativeQuery = true)
	Iterable<Track> getAllTracks();

	@Query(value = "select * from track a where a.trackName = ?1", nativeQuery = true)
	Track findURL(@Param("trackName") String trackName);

	@Query(value = "select * from track a where a.trackName like %?1%", nativeQuery = true)
	Iterable<Track> findTrack(@Param("trackName") String trackName);

}
