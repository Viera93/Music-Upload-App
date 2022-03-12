package com.spring.MusicUploadApp.Repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
 

import com.spring.MusicUploadApp.Model.Track;

public interface TrackRepo extends JpaRepository<Track,Long>{

	void deleteTrackById(Long id);
	
	 

}
