package com.example.service;

import com.example.dtos.request.ReviewRequest;
import com.example.dtos.response.ReviewResponse;
import com.example.mapper.ReviewMapper;
import com.example.model.Movie;
import com.example.model.Reviews;
import com.example.model.Users;
import com.example.repository.MovieRepository;
import com.example.repository.ReviewsRepository;
import com.example.repository.UsersRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewsRepository reviewRepo;
    private final MovieRepository movieRepo;
    private final UsersRepository userRepo;

    public ReviewService(ReviewsRepository reviewRepo,
                         MovieRepository movieRepo,
                         UsersRepository userRepo) {
        this.reviewRepo = reviewRepo;
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
    }

    // CREATE
    public ReviewResponse create(ReviewRequest request, Long userId) {

        Movie movie = movieRepo.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Users user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Reviews review = ReviewMapper.toEntity(request, movie, user);
        reviewRepo.save(review);

        return ReviewMapper.toResponse(review);
    }

    // LIST ALL
    public List<ReviewResponse> list() {
        return reviewRepo.findAll()
                .stream()
                .map(ReviewMapper::toResponse)
                .toList();
    }

    // LIST BY MOVIE
    public List<ReviewResponse> listByMovie(Long movieId) {
        return reviewRepo.findByMovieId(movieId)
                .stream()
                .map(ReviewMapper::toResponse)
                .toList();
    }

    // GET BY ID
    public ReviewResponse getById(Long id) {
        Reviews review = reviewRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return ReviewMapper.toResponse(review);
    }

    // UPDATE
    public ReviewResponse update(Long id, ReviewRequest request) {

        Reviews review = reviewRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        if (request.getReview() != null && !request.getReview().isBlank()) {
            review.setReview(request.getReview());
        }

        // Movie updating is not allowed for review (optional)
        reviewRepo.save(review);

        return ReviewMapper.toResponse(review);
    }

    // DELETE
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }
}
