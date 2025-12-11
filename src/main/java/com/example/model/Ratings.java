package com.example.model;

import jakarta.persistence.*;

@Entity
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ratings;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Users user;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRatings() { return ratings; }
    public void setRatings(Long ratings) { this.ratings = ratings; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }
}
