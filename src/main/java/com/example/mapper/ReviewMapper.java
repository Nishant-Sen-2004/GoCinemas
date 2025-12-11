package com.example.mapper;

import com.example.dtos.UserDto;
import com.example.dtos.request.ReviewRequest;
import com.example.dtos.response.ReviewResponse;
import com.example.model.Movie;
import com.example.model.Reviews;
import com.example.model.Users;

public class ReviewMapper {

    // Create new Review Entity
    public static Reviews toEntity(ReviewRequest request, Movie movie, Users user) {
        Reviews r = new Reviews();
        r.setReview(request.getReview());
        r.setMovie(movie);
        r.setUser(user);
        return r;
    }

    // Convert Entity -> Response
    public static ReviewResponse toResponse(Reviews r) {
        ReviewResponse dto = new ReviewResponse();
        dto.setId(r.getId());
        dto.setReview(r.getReview());
        dto.setMovie(r.getMovie().getId());

        UserDto u = new UserDto();
        u.setId(String.valueOf(r.getUser().getId()));
        u.setUsername(r.getUser().getUsername());
        u.setImages(r.getUser().getImage());
        dto.setUser(u);

        return dto;
    }
}
