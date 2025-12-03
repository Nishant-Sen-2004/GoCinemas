package com.example.dtos.response;

import java.time.LocalDate;
import java.util.List;

import com.example.dtos.MovieDto;
import com.example.dtos.UserDto;
import com.example.enums.ESits;
import com.example.enums.Status;

public class BookResponse {
    private Long id;
    private LocalDate date;
    private List<ESits> sits;
    private Double price;
    private UserDto user;
    private MovieDto movie;
    private Status status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		date = date;
	}
	public List<ESits> getSits() {
		return sits;
	}
	public void setSits(List<ESits> sits) {
		this.sits = sits;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public MovieDto getMovie() {
		return movie;
	}
	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
    
    
}
