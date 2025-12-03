package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.dtos.request.BookRequest;
import com.example.dtos.response.BookResponse;
import com.example.enums.ESits;
import com.example.enums.Status;
import com.example.mapper.BookMapper;
import com.example.model.Book;
import com.example.model.Movie;
import com.example.model.Sits;
import com.example.model.Users;
import com.example.repository.BookRepository;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final MovieService movieService;
    private final UserService usersService;

    public BookService(BookRepository bookRepository, MovieService movieService, UserService usersService) {
        this.bookRepository = bookRepository;
        this.movieService = movieService;
        this.usersService = usersService;
    }

    // CREATE
    public Book create(Long movieId, Long userId, BookRequest request) {

        Movie movie = movieService.findById(movieId);
        Users user = usersService.getById(userId);

        Book book = new Book();
        book.setMovie(movie);
        book.setUser(user);
        book.setDate(request.getDate().atStartOfDay());
        book.setPrice(request.getPrice());
        book.setStatus(Status.PENDING);
        List<Sits> sitEntities = new ArrayList<>();

        for (ESits seatEnum : request.getSits()) {
            Sits sit = new Sits();
            sit.setSit(seatEnum);
            sit.setUser(user);
            sit.setMovie(movie);
            sit.setBook(book);
            sitEntities.add(sit);
        }

        book.setSits(sitEntities);

        return bookRepository.save(book);
    }


    public List<BookResponse> getAllByUser(Long userId) {
        Users user = usersService.getById(userId);

        List<Book> books = bookRepository.findByUser(user);

        return books.stream()
                .map(BookMapper::toResponse)
                .collect(Collectors.toList());
    }
    // GET BY ID
    public BookResponse getById(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return BookMapper.toResponse(book);
    }
    // UPDATE
    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // update simple fields
        book.setDate(request.getDate().atStartOfDay());
        book.setPrice(request.getPrice());

        // replace sits
        book.getSits().clear();

        List<Sits> newSits = request.getSits().stream().map(seat -> {
            Sits s = new Sits();
            s.setSit(seat);
            s.setMovie(book.getMovie());
            s.setUser(book.getUser());
            s.setBook(book);
            return s;
        }).collect(Collectors.toList());

        book.setSits(newSits);

        Book saved = bookRepository.save(book);
        return BookMapper.toResponse(saved);
    }

}
