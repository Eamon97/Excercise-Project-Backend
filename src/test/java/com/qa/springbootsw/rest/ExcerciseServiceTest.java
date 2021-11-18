package com.qa.springbootsw.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.springbootsw.domain.Excercise;
import com.qa.springbootsw.repo.ExcerciseRepo;
import com.qa.springbootsw.services.ExcerciseService;

@RunWith(MockitoJUnitRunner.class)
public class ExcerciseServiceTest {
	@InjectMocks
	private ExcerciseService service;
	
	@Mock
	private ExcerciseRepo repo;
	
	@Test
	public void createTest() {
		Excercise input = new Excercise("bench press", "chest", 5, 5);
		Excercise output = new Excercise(1L,"bench press","chest",5,5, null);
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	@Test
	public void getAllTest() {
		List<Excercise> output = new ArrayList<>();
		output.add(new Excercise("dumbell curl","bicep",12,4));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
}
