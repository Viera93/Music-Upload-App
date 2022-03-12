package com.spring.MusicUploadApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

 
import com.spring.MusicUploadApp.DTO.PostTrackResponse;
import com.spring.MusicUploadApp.Model.Artist;

public interface ArtistRepo extends JpaRepository<Artist,Long> {

	void deleteArtistById(Long id);
	
	//Post Track
	@Query("SELECT new com.spring.MusicUploadApp.DTO.PostTrackResponse(a.artistName, t.trackName, t.content) FROM Artist a JOIN a.tracks t")
	public List<PostTrackResponse> getArtistsAndTracks();

}
