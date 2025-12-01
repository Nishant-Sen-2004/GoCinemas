package com.example.mapper;

import com.example.dtos.request.MovieRequest;
import com.example.dtos.response.MovieListResponse;
import com.example.dtos.response.MovieResponse;
import com.example.model.Movie;
import com.example.model.MovieHall;

public class MovieMapper {

    // Convert Entity -> Response
    public static MovieResponse toResponse(Movie movie, long rating) {
        MovieResponse dto = new MovieResponse();
        dto.setId(movie.getId());
        dto.setMovieName(movie.getMovieName());
        dto.setDescription(movie.getDescription());
        dto.setPrice(movie.getPrice());
        dto.setPicture(movie.getPicture());
        dto.setMovieDuration(movie.getMovieDuration());
        dto.setGenre(movie.getGenre());
        dto.setDirectorName(movie.getDirectorName());
        dto.setCast(movie.getCast());
        dto.setRating(rating);
        return dto;
    }

    // Convert Entity -> List Response
    public static MovieListResponse toListResponse(Movie movie, long rating) {
        MovieListResponse dto = new MovieListResponse();
        dto.setId(movie.getId());
        dto.setMovieName(movie.getMovieName());
        dto.setDescription(movie.getDescription());
        dto.setPrice(movie.getPrice());
        dto.setPicture(movie.getPicture());
        dto.setMovieDuration(movie.getMovieDuration());
        dto.setRating(rating);
        return dto;
    }

    // Convert Request -> New Movie Entity
    public static Movie toEntity(MovieRequest request, MovieHall hall) {
        Movie m = new Movie();
        m.setMovieName(request.getMovieName());
        m.setDescription(request.getDescription());
        m.setPrice(request.getPrice());
        m.setPicture(request.getPicture());
        m.setMovieDuration(request.getMovieDuration());
        m.setGenre(request.getGenre());
        m.setDirectorName(request.getDirectorName());
        m.setCast(request.getCast());
        m.setMovieHall(hall);
        return m;
    }

    // Update Entity (null & empty protection)
    public static void updateMovie(Movie movie, MovieRequest request, MovieHall hall) {

        if (notEmpty(request.getMovieName()))
            movie.setMovieName(request.getMovieName());

        if (notEmpty(request.getDescription()))
            movie.setDescription(request.getDescription());

        if (notEmpty(request.getPrice()))
            movie.setPrice(request.getPrice());

        if (notEmpty(request.getPicture()))
            movie.setPicture(request.getPicture());

        if (notEmpty(request.getMovieDuration()))
            movie.setMovieDuration(request.getMovieDuration());

        if (notEmpty(request.getGenre()))
            movie.setGenre(request.getGenre());

        if (notEmpty(request.getDirectorName()))
            movie.setDirectorName(request.getDirectorName());

        if (notEmpty(request.getCast()))
            movie.setCast(request.getCast());

        if (hall != null)
            movie.setMovieHall(hall);
    }

    private static boolean notEmpty(String val) {
        return val != null && !val.trim().isEmpty();
    }
}
