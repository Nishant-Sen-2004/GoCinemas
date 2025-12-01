package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long>{

    List<Reviews> findByMovieId(Long movieId);

}
