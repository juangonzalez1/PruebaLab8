package com.example.springboot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static final ArrayList<Cities> citieslista = new ArrayList<Cities>();
	citieslista.add(new Cities(1,"Ourense","Ourense"));

	@GetMapping("/cities")
	public Cities cities(@RequestParam(value = "name", defaultValue = "World") String name) {
		return citieslista;
	}
}