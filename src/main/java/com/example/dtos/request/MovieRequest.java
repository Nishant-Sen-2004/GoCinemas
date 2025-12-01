package com.example.dtos.request;

import com.example.model.MovieHall;

public class MovieRequest {
	  	private Long id;
	    private String movieName;
	    private String description;
		private String price;
	    private String picture;
	    private String movieDuration;
	    private String genre;
	    private String directorName;
	    private String cast;
	    private Long  movieHallId;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public String getMovieDuration() {
			return movieDuration;
		}
		public void setMovieDuration(String movieDuration) {
			this.movieDuration = movieDuration;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getDirectorName() {
			return directorName;
		}
		public void setDirectorName(String directorName) {
			this.directorName = directorName;
		}
		public String getCast() {
			return cast;
		}
		public void setCast(String cast) {
			this.cast = cast;
		}
		public Long getMovieHallId() {
			return movieHallId;
		}
		public void setMovieHallId(Long movieHallId) {
			this.movieHallId = movieHallId;
		}
	    
	    
}
