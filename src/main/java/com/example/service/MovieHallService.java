package com.example.service;

import com.example.dtos.MovieHallDTO;
import com.example.mapper.MovieHallMapper;
import com.example.model.MovieHall;
import com.example.repository.MovieHallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieHallService {

    private final MovieHallRepository repo;

    public MovieHallService(MovieHallRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public MovieHallDTO create(MovieHallDTO dto) {
        MovieHall hall = MovieHallMapper.toEntity(dto);
        repo.save(hall);
        return MovieHallMapper.toDTO(hall);
    }

    // READ ALL
    public List<MovieHallDTO> getAll() {
        return repo.findAll().stream()
                .map(MovieHallMapper::toDTO)
                .toList();
    }

    // READ ONE
    public MovieHallDTO getById(Long id) {
        MovieHall hall = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie Hall not found"));

        return MovieHallMapper.toDTO(hall);
    }

    
    public MovieHall findById(Long id) {
        MovieHall hall = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie Hall not found"));

        return hall;
    }
    // UPDATE (with null/empty validation)
    public MovieHallDTO update(Long id, MovieHallDTO dto) {
        MovieHall hall = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie Hall not found"));

        MovieHallMapper.updateEntity(hall, dto);

        repo.save(hall);

        return MovieHallMapper.toDTO(hall);
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
