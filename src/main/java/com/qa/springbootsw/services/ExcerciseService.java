package com.qa.springbootsw.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbootsw.domain.Excercise;
import com.qa.springbootsw.repo.ExcerciseRepo;


@Service
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
		public Excercise getOne(Long excerciseID) {
			return this.repo.findById(excerciseID).get();
		}
		
		// Update
	    public Excercise update(Long excerciseID, Excercise excercise) {
	    	Excercise existing = this.repo.findById(excerciseID).get();
	    	
	    	existing.setExcerciseName(excercise.getExcerciseName());
	    	existing.setMuscleTargeted(excercise.getMuscleTargeted());
	    	existing.setNoOfReps(excercise.getNoOfReps());
	    	existing.setNoOfSets(excercise.getNoOfSets());
	    
	
	    	return this.repo.saveAndFlush(existing);
	    }

	    //delete
	    public boolean delete(Long excerciseID) {
	        
	    	this.repo.deleteById(excerciseID);
	        return !this.repo.existsById(excerciseID);
	    }
	    
	   
	   
	    
}
