package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String image;
    
    @OneToOne
    private MovieHall currentMovieHall;

    @JsonIgnore
    private String password;

    private String phoneNumber;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    

    public String getImage() {
		return image;
	}
	public void setImage(String images) {
		this.image = images;
	}
	public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public MovieHall getCurrentMovieHall() {
		return currentMovieHall;
	}
	public void setCurrentMovieHall(MovieHall currentMovieHall) {
		this.currentMovieHall = currentMovieHall;
	}
    
    
}
