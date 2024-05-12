package com.books.model;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record BarrowerRecord(Long id, @NotBlank String name, @Email String email) {

}
