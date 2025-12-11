package com.example.model;

import jakarta.persistence.*;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String review;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Users user;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }
}
