package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

	private static final ArrayList<Cities> cities = new ArrayList<Cities>();
	cities.add(new Cities("1","Ourense","Ourense"));
	cities.add(new Cities("2","Coruna","Coruna"));
	cities.add(new Cities("3","Pontevedra","Pontevedra"));
	cities.add(new Cities("4","Santiago","Coruna"));
	cities.add(new Cities("5","Lugo","Lugo"));
	cities.add(new Cities("5","Vigo","Pontevedra"));
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/cities")
	public Cities cities() {
		return cities;
	}

	@GetMapping("/cities/{id}")
	public Greeting greeting(@PathVariable Long id) {
		return cities.get(id-1);
	}
}