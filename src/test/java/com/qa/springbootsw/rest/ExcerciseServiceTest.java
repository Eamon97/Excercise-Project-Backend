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
	
	
	/*@Test
	public void testUpdate() {
		Excercise updated = new Excercise(1L, "leg press", "legs", 5, 5);

		Mockito.when(this.repo.findById()).thenReturn(1L);
		
		Mockito.when(this.repo.getString()).thenReturn(updated.getExcerciseName());
    	Mockito.when(this.repo.getString()).thenReturn(updated.getMuscleTargeted());
    	Mockito.when(this.repo.getInt()).thenReturn(updated.getNoOfSets());
		Mockito.when(this.repo.getInt()).thenReturn(updated.getNoOfReps()); 
				
		Mockito.when(this.service.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.repo, Mockito.times(1)).getLong();
		Mockito.verify(this.repo, Mockito.times(2)).getString();
		Mockito.verify(this.repo, Mockito.times(2)).getInt();
		Mockito.verify(this.service, Mockito.times(1)).update(updated);
	}
	*/
	
}
