package com.example.controller;

import com.example.dtos.request.MovieRequest;
import com.example.dtos.response.MovieListResponse;
import com.example.dtos.response.MovieResponse;
import com.example.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public MovieResponse create(@RequestBody MovieRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<MovieListResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public MovieResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable Long id, @RequestBody MovieRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
