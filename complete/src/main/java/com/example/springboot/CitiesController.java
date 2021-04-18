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
	citieslista.add(1,"Ourense","Ourense");
	citieslista.add(2,"A coruña","Ourense");
	citieslista.add(3,"Pontevedra","Ourense");
	citieslista.add(4,"Lugo","Ourense");
	citieslista.add(5,"Vigo","Ourense");


	@GetMapping("/cities")
	public Cities cities(@RequestParam(value = "name", defaultValue = "World") String name) {
		return citieslista;
	}
}