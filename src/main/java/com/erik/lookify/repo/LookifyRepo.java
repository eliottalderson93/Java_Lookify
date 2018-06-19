package com.erik.lookify.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.lookify.models.Song;
@Repository
public interface LookifyRepo extends CrudRepository<Song, Long> {
	//the repo should have all of the database interactions needed in the app
	List<Song> findAll(); //dashboard query
	List<Song> findByArtistContaining(String search); //search query
	Optional<Song> findById(Long id); //singular song page
	void delete(Song delSong);
	void deleteById(Long Id);
	List<Song> findTop10ByOrderByRatingDesc();//query for top 10
}
