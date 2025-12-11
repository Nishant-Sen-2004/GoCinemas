package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Book;
import com.example.model.Users;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByUser(Users user);

}
