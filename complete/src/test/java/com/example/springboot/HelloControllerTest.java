package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void getCities() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/city").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"Ourense\",\"province\":\"Ourense\"},{\"id\":2,\"name\":\"Vigo\",\"province\":\"Pontevedra\"},{\"id\":3,\"name\":\"Lugo\",\"province\":\"Lugo\"},{\"id\":4,\"name\":\"Coru\u00f1a\",\"province\":\"Coru\u00f1a\"},{\"id\":5,\"name\":\"Santiago\",\"province\":\"Coru\u00f1a\"}]")));
	}
}
