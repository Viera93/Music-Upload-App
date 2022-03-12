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
import org.springframework.web.multipart.MultipartFile;

import com.spring.MusicUploadApp.Model.Track;
import com.spring.MusicUploadApp.Service.TrackService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tracks")
public class TrackController {
		
		private final TrackService trackService;
		
		public TrackController(TrackService trackService) {
			this.trackService = trackService;
		}

		@GetMapping
		public ResponseEntity<List<Track>>findAllTracks(){
			List<Track>tracks = trackService.findAllTracks();
			return new ResponseEntity<>(tracks,HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Track>findTrackById(@PathVariable("id")Long id){
			Track track = trackService.findTrackById(id);
			return new ResponseEntity<>(track, HttpStatus.OK);
		}
		
		@PostMapping("/new")
		public ResponseEntity<Track>createNewTrack( @RequestBody Track track, MultipartFile file){
			Track newTrack = trackService.createNewTrack(track, file);
			return new ResponseEntity<>(newTrack, HttpStatus.CREATED);
		}
		
		@PutMapping("/edit/{id}")
		public ResponseEntity<Track>editTrack(@PathVariable("id")Long id,@RequestBody Track track){
			trackService.editTrack(id, track);
			return new ResponseEntity<>(track, HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?>deleteTrack(@PathVariable("id") Long id){
			trackService.deleteTrackById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
}
