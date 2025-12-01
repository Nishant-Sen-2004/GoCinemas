package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Movie movie;
    private String LocalDateTime;

    @ManyToOne
    private Users user;
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Sits> sits;
    private Double price;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }
	public String getLocalDateTime() {
		return LocalDateTime;
	}
	public void setLocalDateTime(String localDateTime) {
		LocalDateTime = localDateTime;
	}
	public List<Sits> getSits() {
		return sits;
	}
	public void setSits(List<Sits> sits) {
		this.sits = sits;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
    
    
}
