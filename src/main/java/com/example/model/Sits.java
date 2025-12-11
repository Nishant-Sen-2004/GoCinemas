package com.example.model;



import com.example.enums.ESits;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
    indexes = {
        @Index(name = "idx_movie", columnList = "movie_id"),
        @Index(name = "idx_booking", columnList = "book_id"),
        @Index(name = "idx_user", columnList = "user_id")
    }
)
public class Sits {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ESits sit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
    @ManyToOne
    private Book book;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ESits getSit() {
		return sit;
	}
	public void setSit(ESits sit) {
		this.sit = sit;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	

}
