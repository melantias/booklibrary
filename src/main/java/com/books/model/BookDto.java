package com.books.model;

import jakarta.validation.constraints.NotBlank;

public record  BookDto(Long id, @NotBlank(message = "ISBN can not be null") String ISBN, String title, String author) {
	

	

}
