package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Sits;

@RestController
@RequestMapping("/v1/api/sits")
public class SitsController {

	@GetMapping("movies/{id}")
	public List<Sits> getBookedsits(@PathVariable("id") Long movieId,@RequestParam("date") LocalDate date) {
	    return sitsService.getBookedSits(movieId, date);
	}
}
