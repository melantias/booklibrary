package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.entity.Barrower;
import com.books.model.BarrowerRecord;
import com.books.service.BarrowerService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/Barrower")
public class BarrowerAPI {
	
	@Autowired
	private BarrowerService barrowerService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Barrower>> getAllBarrowers(){
		 List<Barrower> books = barrowerService.listBarrowers();
		 return new ResponseEntity(books, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Barrower> registerBarrower(@Validated @RequestBody BarrowerRecord barrowerDto){
		Barrower result =  barrowerService.register(barrowerDto);
		return new ResponseEntity(result, HttpStatus.CREATED);
	}
	
	@PostMapping("/barrow/{barrowerId}/book/{bookId}")
	public ResponseEntity<Boolean> barrowBook(@NotNull @PathVariable("bookId") Long bookId, @NotNull @PathVariable("barrowerId") Long barrowerId){
		boolean result =  barrowerService.barrowBook(bookId, barrowerId);
		return new ResponseEntity(result, HttpStatus.CREATED);
	}
	
	@PostMapping("returnbook/{bookId}")
	public ResponseEntity<Boolean> returnBook(@NotNull @PathVariable("bookId") Long bookId){
		boolean result =  barrowerService.returnBook(bookId);
		return new ResponseEntity(result, HttpStatus.CREATED);
	}

}
