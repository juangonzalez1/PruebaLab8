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

		mvc.perform(MockMvcRequestBuilders.get("/cities").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("[{'id':1,'name':'Ourense','province':'Ourense'},{'id':2,'name':'Vigo','province':'Pontevedra'},{'id':3,'name':'Lugo','province':'Lugo'},{'id':4,'name':'Coruña','province':'Coruña'},{'id':5,'name':'Santiago','province':'Coruña'}]"));
	}

	@Test
	public void getCity1() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/cities/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'id':1,'name':'Ourense','province':'Ourense'}"));
	}

	@Test
	public void getCity2() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/cities/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'id':2,'name':'Vigo','province':'Pontevedra'}"));
	}

	@Test
	public void getUniversities() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/universities").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("[{'id':1,'name':'UVIGO','city':'Ourense'},{'id':2,'name':'UVIGO','city':'Vigo'},{'id':3,'name':'USC','city':'Lugo'},{'id':4,'name':'UDC','city':'Coruña'},{'id':5,'name':'USC','city':'Santiago'}]"));
	}

	@Test
	public void getUniversity() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/universities/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'id':1,'name':'UVIGO','city':'Ourense'}"));
	}

}
