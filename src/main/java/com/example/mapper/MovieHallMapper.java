package com.example.mapper;

import com.example.model.MovieHall;
import com.example.dtos.MovieHallDTO;

public class MovieHallMapper {

    // Entity -> DTO
    public static MovieHallDTO toDTO(MovieHall hall) {
        if (hall == null) return null;

        MovieHallDTO dto = new MovieHallDTO();
        dto.setId(hall.getId());
        dto.setImage(hall.getImage());
        dto.setName(hall.getName());
        dto.setLocation(hall.getLocation());
        return dto;
    }

    // DTO -> Entity
    public static MovieHall toEntity(MovieHallDTO dto) {
        if (dto == null) return null;

        MovieHall hall = new MovieHall();
        hall.setImage(dto.getImage());
        hall.setName(dto.getName());
        hall.setLocation(dto.getLocation());
        return hall;
    }

    // Update existing entity (null + empty check)
    public static void updateEntity(MovieHall hall, MovieHallDTO dto) {

        if (dto.getImage() != null && !dto.getImage().trim().isEmpty()) {
            hall.setImage(dto.getImage());
        }

        if (dto.getName() != null && !dto.getName().trim().isEmpty()) {
            hall.setName(dto.getName());
        }

        if (dto.getLocation() != null && !dto.getLocation().trim().isEmpty()) {
            hall.setLocation(dto.getLocation());
        }
    }
}
