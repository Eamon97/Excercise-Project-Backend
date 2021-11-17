package com.qa.springbootsw.services;

import java.util.List;


import com.qa.springbootsw.domain.WorkoutPlan;

import com.qa.springbootsw.repo.WorkoutRepo;

public class WorkoutService {
	
private WorkoutRepo repo;
	
	public WorkoutService(WorkoutRepo repo) {
		this.repo = repo;
	}
		
		// Create
		public WorkoutPlan create(WorkoutPlan workoutPlan) {
			return this.repo.saveAndFlush(workoutPlan);
		}
		
		// Read All
		public List<WorkoutPlan> getAll() {
			// Return the whole list
			return this.repo.findAll();
		}
		
		// Read One
		public WorkoutPlan getOne(Long id) {
			return this.repo.findById(id).get();
		}
		
		// Update
	    public WorkoutPlan update(Long id, WorkoutPlan workoutPlan) {
	    	WorkoutPlan existing = this.repo.findById(id).get();
	    	
	    	existing.setDayOfWeek(workoutPlan.getDayOfWeek());
	 
	    	existing.setExcercises(workoutPlan.getExcercises());
	    
	
	    	return this.repo.saveAndFlush(existing);
	    }

	    public boolean delete(Long id) {
	        
	    	this.repo.deleteById(id);
	        return !this.repo.existsById(id);
	    }
	    
	   

}
