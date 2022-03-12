package com.spring.MusicUploadApp.DTO;

public class PostTrackResponse {
	
	private String artistName;
	private String trackName;
	private String content;
	
	
	
	public PostTrackResponse() {
	}

	public PostTrackResponse(String artistName, String trackName, String content) {
		super();
		this.artistName = artistName;
		this.trackName = trackName;
		this.content = content;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
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
		return "PostTrackResponse [artistName=" + artistName + ", trackName=" + trackName + ", content=" + content
				+ "]";
	}
	

}
