package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, Long>{
    @Query("SELECT AVG(r.ratings) FROM Ratings r WHERE r.movie.id = :movieId")
    Double getAverageRating(Long movieId);
}
