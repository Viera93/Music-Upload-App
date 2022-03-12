package com.spring.MusicUploadApp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.Lob;
 
import javax.persistence.Table;

@Entity
@Table(name="track")
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="track_name")
	private String trackName;
	
	
	@Lob
	@Column(columnDefinition="MEDIUMBLOB")
	private String content;
	
	//Constructors
	public Track() {
	}

	public Track(String trackName, String content) {
		super();
		this.trackName = trackName;
		this.content = content;
	}

	//Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	 

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", trackName=" + trackName + ", content=" + content + "]";
	}

	 
}
