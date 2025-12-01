package com.example.dtos.request;

import java.util.List;

import com.example.enums.Sits;



public class BookRequest {
    private Long id;
    private String LocalDateTime;
    private List<Sits> sits;
    private Double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocalDateTime() {
		return LocalDateTime;
	}
	public void setLocalDateTime(String localDateTime) {
		LocalDateTime = localDateTime;
	}
	public List<Sits> getSits() {
		return sits;
	}
	public void setSits(List<Sits> sits) {
		this.sits = sits;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	    
    
}
