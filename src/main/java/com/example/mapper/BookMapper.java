package com.example.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.dtos.MovieDto;
import com.example.dtos.UserDto;
import com.example.dtos.response.BookResponse;
import com.example.enums.ESits;
import com.example.model.Book;
import com.example.model.Sits;

public class BookMapper {

    // Convert Entity → Response
    public static BookResponse toResponse(Book book) {

        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setDate(book.getDate().toLocalDate());
        response.setPrice(book.getPrice());
        response.setStatus(book.getStatus());
        // Convert Sits list -> Enum list
        List<ESits> sitList = book.getSits()
                .stream()
                .map(Sits::getSit)
                .collect(Collectors.toList());
        response.setSits(sitList);

        // --- User Mapping ---
        UserDto userDto = new UserDto();
        userDto.setId(book.getUser().getId().toString());
        userDto.setUsername(book.getUser().getUsername());
        response.setUser(userDto);

        // --- Movie Mapping ---
        MovieDto movieDto = new MovieDto();
        movieDto.setId(book.getMovie().getId());
        movieDto.setMovieName(book.getMovie().getMovieName());
        movieDto.setPicture(book.getMovie().getPicture());
        response.setMovie(movieDto);

        return response;
    }

}
