package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.entity.Book;
import com.books.model.BookDto;
import com.books.service.Bookservice;

@RestController
@RequestMapping("/Books")
public class BookAPI {
	
	@Autowired
	private Bookservice bookService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Book>> getAllBooks(){
		 List<Book> books = bookService.getAllBooks();
		 return new ResponseEntity(books, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Book> registerBook(@Validated @RequestBody BookDto bookDto){
		Book result =  bookService.registerBook(bookDto);
		return new ResponseEntity(result, HttpStatus.OK);
	}

}
