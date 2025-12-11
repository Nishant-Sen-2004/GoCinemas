package com.example.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Sits;

public interface SitRepository extends JpaRepository<Sits, Long>{
	@Query("SELECT s FROM Sits s WHERE s.movie.id = :movieId AND s.book.date BETWEEN :start AND :end")
	List<Sits> findBookedSits(Long movieId, LocalDateTime start, LocalDateTime end);

}
