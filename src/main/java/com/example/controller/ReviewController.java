package com.example.controller;

import com.example.dtos.request.ReviewRequest;
import com.example.dtos.response.ReviewResponse;
import com.example.service.ReviewService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public ReviewResponse create(@RequestBody ReviewRequest req, @PathVariable Long userId) {
        return service.create(req, userId);
    }

    @GetMapping
    public List<ReviewResponse> list() {
        return service.list();
    }

    @GetMapping("/movie/{movieId}")
    public List<ReviewResponse> listByMovie(@PathVariable Long movieId) {
        return service.listByMovie(movieId);
    }

    @GetMapping("/{id}")
    public ReviewResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ReviewResponse update(@PathVariable Long id, @RequestBody ReviewRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
