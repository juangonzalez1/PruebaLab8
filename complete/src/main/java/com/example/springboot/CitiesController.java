package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

	private static final ArrayList<Cities> cities = new ArrayList<Cities>();
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/cities")
	public Cities cities() {
		return new Cities("1", "Ourense","Ourense");
	}

	@GetMapping("/cities/{id}")
	public Greeting greeting(@PathVariable Long id) {
		return new Cities("1", "Ourense","Ourense");
	}
}