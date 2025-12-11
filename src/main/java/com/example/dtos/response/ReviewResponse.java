package com.example.dtos.response;

import com.example.dtos.UserDto;
import com.example.model.Movie;
import com.example.model.Users;

import jakarta.persistence.ManyToOne;

public class ReviewResponse {
    private Long id;
    private String review;
    private Long movie;
    private UserDto user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Long getMovie() {
		return movie;
	}
	public void setMovie(Long movie) {
		this.movie = movie;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}   
}
