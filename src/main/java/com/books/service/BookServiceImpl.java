package com.books.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.entity.Book;
import com.books.model.BookDto;
import com.books.repository.BookRepository;

@Service
public class BookServiceImpl implements Bookservice {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book registerBook(BookDto bookDto) {
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		return  bookRepository.save(book);
	}

}
