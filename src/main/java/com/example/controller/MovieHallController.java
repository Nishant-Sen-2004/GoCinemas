package com.example.controller;

import com.example.dtos.MovieHallDTO;
import com.example.service.MovieHallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-halls")
public class MovieHallController {

    private final MovieHallService service;

    public MovieHallController(MovieHallService service) {
        this.service = service;
    }

    @PostMapping
    public MovieHallDTO create(@RequestBody MovieHallDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<MovieHallDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MovieHallDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public MovieHallDTO update(@PathVariable Long id, @RequestBody MovieHallDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
