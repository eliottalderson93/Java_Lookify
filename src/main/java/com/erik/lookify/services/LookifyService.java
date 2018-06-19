package com.erik.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erik.lookify.models.Song;
import com.erik.lookify.repo.LookifyRepo;

@Service
public class LookifyService {
	private final LookifyRepo lookRepo;
	public LookifyService(LookifyRepo lookRepo) {
		this.lookRepo = lookRepo;
	}
	public List<Song> allSongs(){
		return lookRepo.findAll();
	}
	public Song createSong(Song s) {
		return lookRepo.save(s);
	}
	public Song findSong(Long id) {
		Optional<Song> optSong = lookRepo.findById(id);
		if (optSong.isPresent()) {
			return optSong.get();
		}
		else {
			return null;
		}
	}
	public List<Song> artistSearch(String search){
		return lookRepo.findByArtistContaining(search);
	}
	
	public List<Song> topTen(){
		return lookRepo.findTop10ByOrderByRatingDesc();
	}
	public void delete(Song delSong) {
		lookRepo.deleteById(delSong.getId());
	}
	public void deleteById(Long Id) {
		lookRepo.deleteById(Id);
	}
}
