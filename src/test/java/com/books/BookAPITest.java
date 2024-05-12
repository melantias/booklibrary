package com.books;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.books.controller.BookAPI;
import com.books.entity.Book;
import com.books.service.Bookservice;

@WebMvcTest(BookAPI.class)
class BookrAPITest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Bookservice service;

	@Test
	void greetingShouldReturnMessageFromService() throws Exception {
		List<Book> books = new ArrayList<Book>();
		when(service.getAllBooks()).thenReturn(books);
		this.mockMvc.perform(get("/Books/list")).andExpect(status().isOk());
	}
}
