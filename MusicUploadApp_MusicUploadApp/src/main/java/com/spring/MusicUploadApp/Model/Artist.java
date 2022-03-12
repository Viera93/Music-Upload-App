package com.spring.MusicUploadApp.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="artist_name")
	private String artistName;
    
	//Constructors
	public Artist() {
	}

	public Artist(String artistName) {
		this.artistName = artistName;
	}
	
	
	public Artist(String artistName, List<Track> tracks) {
		super();
		this.artistName = artistName;
		this.tracks = tracks;
	}
	

	//Artist -- Tracks
	@OneToMany(targetEntity = Track.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "artist_id", referencedColumnName = "id")
    private List<Track>tracks = new ArrayList<>();
	
	 
	
	//Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", artistName=" + artistName + ", tracks=" + tracks + "]";
	}

 

	 
	
	

	 
	
	
	
	

}
