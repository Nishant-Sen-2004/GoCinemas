package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieName;
    private String description;
	private String price;
    private String picture;
    private String movieDuration;
//    private LocalDateTime fromTime;
//    private LocalDateTime toTime;
    private String genre;
    private String directorName;
    private String cast;
    @ManyToOne
    private MovieHall movieHall;
    
//
//    @OneToMany(mappedBy = "movie")
//    private List<Book> bookings;
//
//    @OneToMany(mappedBy = "movie")
//    private List<Ratings> ratings;
//
//    @OneToMany(mappedBy = "movie")
//    private List<Reviews> reviews;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }

    public String getMovieDuration() { return movieDuration; }
    public void setMovieDuration(String movieDuration) { this.movieDuration = movieDuration; }


    
    public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public MovieHall getMovieHall() {
		return movieHall;
	}
	public void setMovieHall(MovieHall movieHall) {
		this.movieHall = movieHall;
	}
	
	
    
}
