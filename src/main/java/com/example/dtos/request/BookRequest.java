package com.example.dtos.request;

import java.time.LocalDate;
import java.util.List;

import com.example.enums.ESits;






public class BookRequest {
    private Long id;
    private LocalDate date;
    private List<ESits> sits;
    private Double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<ESits> getSits() {
		return sits;
	}
	public void setSits(List<ESits> sits) {
		this.sits = sits;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	    
    
}
