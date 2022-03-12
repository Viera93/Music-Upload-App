package com.spring.MusicUploadApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.MusicUploadApp.Model.Artist;
import com.spring.MusicUploadApp.Service.ArtistService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/artists")
public class ArtistController {
	
	private final ArtistService artistService;
	
	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping
	public ResponseEntity<List<Artist>>findAllArtists(){
		List<Artist>artists = artistService.findAllArtists();
		return new ResponseEntity<>(artists,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Artist>findArtistById(@PathVariable("id")Long id){
		Artist artist = artistService.findArtistById(id);
		return new ResponseEntity<>(artist, HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<Artist>createNewArtist(@RequestBody Artist artist){
		Artist newArtist = artistService.createNewArtist(artist);
		return new ResponseEntity<>(newArtist, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Artist>editArtist(@PathVariable("id")Long id,@RequestBody Artist artist){
		artistService.editArtist(id, artist);
		return new ResponseEntity<>(artist, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteArtist(@PathVariable("id") Long id){
		artistService.deleteArtist(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
