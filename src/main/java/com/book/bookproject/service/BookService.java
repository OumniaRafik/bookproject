package com.book.bookproject.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import com.book.bookproject.entity.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public List<Book> searchBooks(@RequestParam String q);
}
