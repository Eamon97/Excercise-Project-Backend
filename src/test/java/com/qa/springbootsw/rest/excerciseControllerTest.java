package com.qa.springbootsw.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springbootsw.domain.Excercise;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
@AutoConfigureMockMvc 
@ActiveProfiles("test") 

@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:dataPlan.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class excerciseControllerTest {
	
	@Autowired 
	private MockMvc mvc; 

	@Autowired
	private ObjectMapper mapper; 

	@Test
	void testCreate() throws Exception {
		
		Excercise ex1 = new Excercise("Bench press", "chest",5,5);
		String ex1AsJSON = this.mapper.writeValueAsString(ex1);
		RequestBuilder request = post("/Excercise/create").contentType(MediaType.APPLICATION_JSON).content(ex1AsJSON);

		ResultMatcher checkStatus = status().isCreated(); 

		Excercise exSaved = new Excercise("Bench press", "chest",5,5);
		String exSavedAsJSON = this.mapper.writeValueAsString(exSaved);

		ResultMatcher checkBody = content().json(exSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	
	@Test
	void testGet() throws Exception {
		Excercise ex1 = new Excercise("Bench press", "chest",5,5);
		
		String exAsJSON = this.mapper.writeValueAsString(ex1);
		RequestBuilder request = get("/Excercise/getOne/1");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(exAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {
		Excercise ex1 = new Excercise("Bench press", "chest",5,5);
		String exJSON = this.mapper.writeValueAsString(List.of(ex1));
		RequestBuilder request = get("/Excercise/getAll");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(exJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	

	@Test
	void testUpdate() throws Exception {
		Excercise ex1 = new Excercise("Bench press", "chest",5,5);
		String exAsJSON = this.mapper.writeValueAsString(ex1);
		RequestBuilder request = put("/Excercise/update/1").contentType(MediaType.APPLICATION_JSON).content(exAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); 

		Excercise ex2 = new Excercise("dumbell curl", "bicep",10,5);
		String ex2SavedAsJSON = this.mapper.writeValueAsString(ex2);

		ResultMatcher checkBody = content().json(ex2SavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/Excercise/delete/1")).andExpect(status().isNoContent());
	}

}

	
	
	
