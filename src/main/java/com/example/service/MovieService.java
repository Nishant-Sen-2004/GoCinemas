package com.example.service;

import com.example.dtos.request.MovieRequest;
import com.example.dtos.response.MovieListResponse;
import com.example.dtos.response.MovieResponse;
import com.example.mapper.MovieMapper;
import com.example.model.Movie;
import com.example.model.MovieHall;
import com.example.repository.MovieHallRepository;
import com.example.repository.MovieRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepo;
    private final MovieHallRepository hallRepo;
    private final RatingsService ratingService;

    public MovieService(MovieRepository movieRepo,
                        MovieHallRepository hallRepo,
                        RatingsService ratingService) {
        this.movieRepo = movieRepo;
        this.hallRepo = hallRepo;
        this.ratingService = ratingService;
    }

    // CREATE
    public MovieResponse create(MovieRequest request) {

        MovieHall hall = hallRepo.findById(request.getMovieHallId())
                .orElseThrow(() -> new RuntimeException("Movie Hall not found"));

        Movie movie = MovieMapper.toEntity(request, hall);
        movieRepo.save(movie);

        long avgRating = ratingService.getAverageRating(movie.getId());

        return MovieMapper.toResponse(movie, avgRating);
    }

    // LIST ALL MOVIES
    public List<MovieListResponse> list() {
        return movieRepo.findAll()
                .stream()
                .map(movie -> {
                    long avgRating = ratingService.getAverageRating(movie.getId());
                    return MovieMapper.toListResponse(movie, avgRating);
                })
                .toList();
    }

    // GET BY ID
    public MovieResponse getById(Long id) {
        Movie movie = movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        long avgRating = ratingService.getAverageRating(id);

        return MovieMapper.toResponse(movie, avgRating);
    }

    // UPDATE MOVIE
    public MovieResponse update(Long id, MovieRequest request) {

        Movie movie = movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        MovieHall hall = null;
        if (request.getMovieHallId() != null) {
            hall = hallRepo.findById(request.getMovieHallId())
                    .orElseThrow(() -> new RuntimeException("Movie Hall not found"));
        }

        MovieMapper.updateMovie(movie, request, hall);
        movieRepo.save(movie);

        long avgRating = ratingService.getAverageRating(movie.getId());

        return MovieMapper.toResponse(movie, avgRating);
    }

    // DELETE
    public void delete(Long id) {
        movieRepo.deleteById(id);
    }

    // For internal use (RatingService or others)
    public Movie findById(long movieId) {
        return movieRepo.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}
