package com.spring.MusicUploadApp.DTO;

import com.spring.MusicUploadApp.Model.Artist;

public class PostRequest {
	
	private Artist artist;

	public PostRequest() {
	}

	public PostRequest(Artist artist) {
		super();
		this.artist = artist;
	}
	
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "PostTrackRequest [artist=" + artist + "]";
	}

}
