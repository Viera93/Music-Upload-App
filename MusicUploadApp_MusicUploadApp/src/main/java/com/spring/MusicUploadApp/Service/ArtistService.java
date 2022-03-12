package com.spring.MusicUploadApp.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.MusicUploadApp.Exception.ResourceNotFoundException;
import com.spring.MusicUploadApp.Model.Artist;
import com.spring.MusicUploadApp.Repository.ArtistRepo;

@Service
@Transactional
public class ArtistService {
	
	private final ArtistRepo artistRepo;

	@Autowired
	public ArtistService(ArtistRepo artistRepo) {
		this.artistRepo = artistRepo;
	}
	
	public List<Artist>findAllArtists(){
		return artistRepo.findAll();
	}
	public Artist findArtistById(Long id) {
    	return artistRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Artist not found"));
    }
	
	public Artist createNewArtist(Artist artist) {
		return artistRepo.save(artist);
	}
	public Artist editArtist(Long id, Artist artist) {
    	Artist updatedArtist = artistRepo.findById(id).get();
    	updatedArtist.setArtistName(artist.getArtistName());
    	return artistRepo.save(updatedArtist);
    }
	
	public void deleteArtist(Long id) {
    	artistRepo.deleteArtistById(id);
    }
	
	
}
