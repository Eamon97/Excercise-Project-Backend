package com.qa.springbootsw.services;

import java.util.List;

import com.qa.springbootsw.domain.Excercise;
import com.qa.springbootsw.repo.ExcerciseRepo;



public class ExcerciseService {

private ExcerciseRepo repo;
	
	public ExcerciseService(ExcerciseRepo repo) {
		this.repo = repo;
	}
		
		// Create
		public Excercise create(Excercise excercise) {
			return this.repo.saveAndFlush(excercise);
		}
		
		// Read All
		public List<Excercise> getAll() {
			// Return the whole list
			return this.repo.findAll();
		}
		
		// Read One
		public Excercise getOne(Long id) {
			return this.repo.findById(id).get();
		}
		
		// Update
	    public Excercise update(Long id, Excercise excercise) {
	    	Excercise existing = this.repo.findById(id).get();
	    	
	    	existing.setExcerciseName(excercise.getExcerciseName());
	    	existing.setMuscleTargeted(excercise.getMuscleTargeted());
	    	existing.setNoOfReps(excercise.getNoOfReps());
	    	existing.setNoOfSets(excercise.getNoOfSets());
	    
	
	    	return this.repo.saveAndFlush(existing);
	    }

	    public boolean delete(Long id) {
	        
	    	this.repo.deleteById(id);
	        return !this.repo.existsById(id);
	    }
	    
	   
	   
	    
}
