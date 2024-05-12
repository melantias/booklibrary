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

import com.books.controller.BarrowerAPI;
import com.books.entity.Barrower;
import com.books.service.BarrowerService;

@WebMvcTest(BarrowerAPI.class)
class BarrowerAPITest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BarrowerService service;

	@Test
	void greetingShouldReturnMessageFromService() throws Exception {
		List<Barrower> barrrowers = new ArrayList<Barrower>();
		when(service.listBarrowers()).thenReturn(barrrowers);
		this.mockMvc.perform(get("/Barrower/list")).andExpect(status().isOk());
	}
}