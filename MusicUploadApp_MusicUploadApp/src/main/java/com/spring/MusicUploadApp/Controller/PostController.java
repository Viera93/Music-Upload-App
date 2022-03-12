package com.spring.MusicUploadApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.spring.MusicUploadApp.DTO.PostRequest;
import com.spring.MusicUploadApp.DTO.PostTrackResponse;
import com.spring.MusicUploadApp.Model.Artist;
import com.spring.MusicUploadApp.Repository.ArtistRepo;
import com.spring.MusicUploadApp.Repository.TrackRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private TrackRepo trackRepo;
	
	@Autowired
	private ArtistRepo artistRepo;
	
	//TRACK
	@PostMapping("/post-track")
	public Artist postTrack(@RequestBody PostRequest request) {
		return artistRepo.save(request.getArtist());
	}
	
	@GetMapping("/find-all-tracks")
	public List<Artist>findAllTracks(){
		return artistRepo.findAll();
	}
	
	@GetMapping("/artists-tracks")
	public List<PostTrackResponse>getArtistTracks(){
		return artistRepo.getArtistsAndTracks();
	}
	
	 
	 
	 
	

}
