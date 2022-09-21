package HelloWorld;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import HelloWorld.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {

	@Query(value = "Select * from artist", nativeQuery = true)
	Iterable<Artist> getAllArtists();

	@Query(value = "select * from artist a where a.artistName = ?1 limit 1", nativeQuery = true)
	Artist findId(@Param("artistName") String artistName);

	@Query(value = "Select LAST_INSERT_ID()", nativeQuery = true)
	Integer findLastId();
}
