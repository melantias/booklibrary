package com.books.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.books.entity.Barrower;
import com.books.entity.Book;
import com.books.entity.BookAvailabilityTrans;
import com.books.model.BarrowerRecord;
import com.books.repository.BarrowerRepository;
import com.books.repository.BookAvailabilityTransRepository;
import com.books.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BarrowerServiceImpl implements BarrowerService {
	
	@Autowired
	private BarrowerRepository barrowerRepository;
	
	@Autowired
	private BookAvailabilityTransRepository transRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Barrower register(BarrowerRecord barrowerDto) {
		Barrower book = new Barrower();
		BeanUtils.copyProperties(barrowerDto, book);
		return barrowerRepository.save(book);
	}

	@Override
	@Transactional
	public boolean barrowBook(Long bookId, Long barrowerId) {
		
		BookAvailabilityTrans trans = transRepository.findByBookId(bookId);
		if(trans !=null) {
			return false;
		}
		Optional<Book> book = bookRepository.findById(bookId);
		Optional<Barrower> barrower = barrowerRepository.findById(barrowerId);
		
		
		if(book.isPresent() && barrower.isPresent()) {
			BookAvailabilityTrans transnew = new BookAvailabilityTrans();
			transnew.setBookId(bookId);
			transnew.setBarrowerId(barrower.get().getBarrowerId());
			transRepository.save(transnew);
			return true;
		}
		return false;
	}

	@Override
	public boolean returnBook(Long bookId) {
		BookAvailabilityTrans trans = transRepository.findByBookId(bookId);
			transRepository.delete(trans);
		return true;
	}

	@Override
	public List<Barrower> listBarrowers() {
		return (List<Barrower>) barrowerRepository.findAll();
	}

}
