package com.example.controller;

import com.example.dtos.request.BookRequest;
import com.example.dtos.response.BookResponse;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/movies/{movieId}/users/{userId}")
    public BookResponse createBooking(
            @PathVariable Long movieId,
            @PathVariable Long userId,
            @RequestBody BookRequest request) {

        return BookMapper.toResponse(
                bookService.create(movieId, userId, request)
        );
    }

    @GetMapping("/users/{userId}")
    public List<BookResponse> getAllBookingsByUser(@PathVariable Long userId) {
        return bookService.getAllByUser(userId);
    }

    @GetMapping("/{id}")
    public BookResponse getBookingById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PutMapping("/{id}")
    public BookResponse updateBooking(
            @PathVariable Long id,
            @RequestBody BookRequest request) {

        return bookService.updateBook(id, request);
    }
}
