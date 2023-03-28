package com.book.bookproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.book.bookproject.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Override	
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();

        books.add(new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        books.add(new Book(2L, "To Kill a Mockingbird", "Harper Lee", "Fiction"));
        books.add(new Book(3L, "1984", "George Orwell", "Science Fiction"));

        return books;
	}

	@Override
	public List<Book> searchBooks(String q) {
		RestTemplate restTemplate = new RestTemplate();

		Book[] objects = restTemplate.getForObject("http://localhost:8090/books", Book[].class);
		List<Book> books = Arrays.asList(objects);
		
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(q.toLowerCase())
                        || book.getAuthor().toLowerCase().contains(q.toLowerCase())
                        || book.getCategory().toLowerCase().contains(q.toLowerCase()))
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
        return filteredBooks;
	}
}
