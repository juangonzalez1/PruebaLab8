package com.example.springboot;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	ArrayList<Cities> citieslista = new ArrayList<Cities>();


	@GetMapping("/cities")
	public ArrayList<Cities> cities() {
		citieslista.add(new Cities(1,"Ourense","Ourense"));
		citieslista.add(new Cities(2,"Vigo","Pontevedra"));
		citieslista.add(new Cities(3,"Lugo","Lugo"));
		citieslista.add(new Cities(4,"Coruña","Coruña"));
		return citieslista;
	}
}