package com.example.controller;

import com.example.dtos.request.RatingRequest;
import com.example.model.Ratings;
import com.example.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/ratings")
public class RatingsController {
	   @Autowired
	    private RatingsService ratingsService;

	    @PostMapping("/create/{userId}")
	    public Ratings createRating(
	            @PathVariable Long userId,
	            @RequestBody RatingRequest request) {

	        return ratingsService.create(userId, request);
	    }
}
