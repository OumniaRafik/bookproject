package com.book.bookproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookproject.entity.Book;
import com.book.bookproject.service.BookService;

@RestController
public class BookConroller {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/search")
	public List<Book> searchBooks(@RequestParam String q) {
		return bookService.searchBooks(q);
	}
}
