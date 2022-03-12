package com.spring.MusicUploadApp.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.MusicUploadApp.Exception.ResourceNotFoundException;
import com.spring.MusicUploadApp.Model.Track;
import com.spring.MusicUploadApp.Repository.TrackRepo;

@Service
@Transactional
public class TrackService {
	
	private final TrackRepo trackRepo;

	@Autowired
	public TrackService(TrackRepo trackRepo) {
		this.trackRepo = trackRepo;
	}
	
	public List<Track>findAllTracks(){
		return trackRepo.findAll();
	}
	
	public Track findTrackById(Long id) {
		return trackRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Track was not found"));
	}
	
//	public Track createNewTrack(Track track) {
//		return trackRepo.save(track);
//	}
	
	public Track createNewTrack(Track track, MultipartFile file) {
		 
		 
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.contains("..")) {
			System.out.println("NOT A VALID FILE");
		}
		
		try {
			track.setContent(Base64.getEncoder().encodeToString(file.getBytes()));
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		track.setTrackName(track.getTrackName());
		return trackRepo.save(track);
	}
	
	public Track editTrack(Long id, Track track) {
		Track updatedTrack = trackRepo.findById(id).get();
		updatedTrack.setTrackName(track.getTrackName());
		return trackRepo.save(updatedTrack);
	}
	
	public void deleteTrackById(Long id) {
		trackRepo.deleteTrackById(id);
	}
	

}
