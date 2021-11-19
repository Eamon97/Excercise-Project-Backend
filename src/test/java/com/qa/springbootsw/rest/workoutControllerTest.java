package com.qa.springbootsw.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springbootsw.domain.Excercise;
import com.qa.springbootsw.domain.WorkoutPlan;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
@AutoConfigureMockMvc 
@ActiveProfiles("test") 

@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:dataPlan.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class workoutControllerTest {
	@Autowired 
	private MockMvc mvc; 

	@Autowired
	private ObjectMapper mapper; 

	private List<Excercise> excercises=Collections.unmodifiableList(new ArrayList<>());
	
	
	@Test
	void testCreate() throws Exception {
		
		WorkoutPlan wp1 = new WorkoutPlan("tuesday", excercises);
		String wp1AsJSON = this.mapper.writeValueAsString(wp1);
		RequestBuilder request = post("/WorkoutPlan/create").contentType(MediaType.APPLICATION_JSON).content(wp1AsJSON);

		ResultMatcher checkStatus = status().isCreated(); 

		WorkoutPlan wpSaved = new WorkoutPlan("tuesday",excercises);
		String wpSavedAsJSON = this.mapper.writeValueAsString(wpSaved);

		ResultMatcher checkBody = content().json(wpSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	
	@Test
	void testGet() throws Exception {
		WorkoutPlan wp1 = new WorkoutPlan("tuesday", excercises);
		
		String wpAsJSON = this.mapper.writeValueAsString(wp1);
		RequestBuilder request = get("/WorkoutPlan/getOne/1");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(wpAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {
		WorkoutPlan wp1 = new WorkoutPlan("friday", excercises);
		String wpJSON = this.mapper.writeValueAsString(List.of(wp1));
		RequestBuilder request = get("/WorkoutPlan/getAll");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(wpJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	

	@Test
	void testUpdate() throws Exception {
		WorkoutPlan wp1 = new WorkoutPlan("tuesday",excercises);
		String wpAsJSON = this.mapper.writeValueAsString(wp1);
		RequestBuilder request = put("/WorkoutPlan/update/1").contentType(MediaType.APPLICATION_JSON).content(wpAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); 

		WorkoutPlan wp2 = new WorkoutPlan("thursday",excercises);
		String wp2SavedAsJSON = this.mapper.writeValueAsString(wp2);

		ResultMatcher checkBody = content().json(wp2SavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/WorkoutPlan/delete/1")).andExpect(status().isNoContent());
	}


}
