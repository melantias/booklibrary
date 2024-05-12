package com.books.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Barrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "barrower_id")
	private Long barrowerId;
	
	@Column
	private String name;
	
	@Column
	private String email;


	public Long getBarrowerId() {
		return barrowerId;
	}

	public void setBarrowerId(Long barrowerId) {
		this.barrowerId = barrowerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
