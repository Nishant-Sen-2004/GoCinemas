package com.example.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewRequest {
	
private long id;
private long movieId;
private String review;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
	
}
public long getMovieId() {
	return movieId;
}
public void setMovieId(long movieId) {
	this.movieId = movieId;
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}

}
