package com.erik.lookify.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 1, max = 30)
	private String title;
	@Size(min = 3, max = 20)
	private String artist;
	@Min(1)
	@Max(10)
	private Integer rating;
	@Column(updatable = false)
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Song() {}
	public Song(String Title, String Artist, Integer Rating) {
		this.title = Title;
		this.artist = Artist;
		this.rating = Rating;
	}
	//setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String Title) {
		this.title = Title;
	}
	public void setArtist(String Artist) {
		this.artist = Artist;
	}
	public void setRating(Integer Rating) {
		this.rating = Rating;
	}
	//getters
	public Long getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getArtist() {
		return this.artist;
	}
	public Integer getRating() {
		return this.rating;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
