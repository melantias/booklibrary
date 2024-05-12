package com.books.repository;

import org.springframework.data.repository.CrudRepository;

import com.books.entity.BookAvailabilityTrans;

public interface BookAvailabilityTransRepository extends CrudRepository<BookAvailabilityTrans, Long>{
	
	BookAvailabilityTrans findByBookId(Long bookId);

}
