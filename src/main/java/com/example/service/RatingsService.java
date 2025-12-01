package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.request.RatingRequest;
import com.example.model.Movie;
import com.example.model.Ratings;
import com.example.model.Users;
import com.example.repository.RatingsRepository;

@Service
public class RatingsService {
	  @Autowired
	    private RatingsRepository ratingsRepository;

	    @Autowired
	    private MovieService movieService;

	    @Autowired
	    private UserService userService;

	    public Ratings create(Long userId, RatingRequest request) {

	        // 1. Find User
	        Users user = userService.getById(userId);

	        // 2. Find Movie
	        Movie movie = movieService.findById(request.getMovieId());

	        // 3. Create Rating
	        Ratings rating = new Ratings();
	        rating.setUser(user);
	        rating.setMovie(movie);
	        rating.setRatings(request.getRating());

	        // 4. Save
	        return ratingsRepository.save(rating);
	    }
	    
	    public long getAverageRating(Long movieId) {
	        Double avg = ratingsRepository.getAverageRating(movieId);
	        return avg == null ? 0 : Math.round(avg);
	    }
}
