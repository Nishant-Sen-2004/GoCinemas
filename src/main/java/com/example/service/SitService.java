package com.example.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.model.Sits;
import com.example.repository.SitRepository;

public class SitService {
	
	private final SitRepository sitsRepository;
	
	public SitService(SitRepository sitRepository) {
		this.sitsRepository=sitRepository;
	}
	
	public List<Sits> getBookedSits(Long movieId, LocalDate date) {

	    LocalDateTime start = date.atStartOfDay();
	    LocalDateTime end = date.atTime(23, 59, 59);

	    return sitsRepository.findBookedSits(movieId, start, end);
	}

}
