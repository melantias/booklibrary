package com.books.service;

import java.util.List;

import com.books.entity.Book;
import com.books.model.BookDto;

public interface Bookservice {
	
	List<Book> getAllBooks();
	
	Book registerBook(BookDto bookDto);

}
