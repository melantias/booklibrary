package com.books.service;

import java.util.List;

import com.books.entity.Barrower;
import com.books.model.BarrowerRecord;

public interface BarrowerService {
	
	public Barrower register(BarrowerRecord barrower);
	public boolean barrowBook(Long bookId, Long BarrowerId);
	public boolean returnBook(Long bookId);
	public List<Barrower> listBarrowers();

}
