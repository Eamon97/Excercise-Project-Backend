package com.qa.springbootsw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootsw.domain.WorkoutPlan;

import com.qa.springbootsw.repo.WorkoutRepo;

@Service
public class WorkoutService {
	
	@Autowired
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
		public WorkoutPlan getOne(Long sessionID) {
			return this.repo.findById(sessionID).get();
		}
		
		// Update
	    public WorkoutPlan update(Long sessionID, WorkoutPlan workoutPlan) {
	    	WorkoutPlan existing = this.repo.findById(sessionID).get();
	    	
	    	existing.setDayOfWeek(workoutPlan.getDayOfWeek());
	 
	    	existing.setExcercises(workoutPlan.getExcercises());
	    
	
	    	return this.repo.saveAndFlush(existing);
	    }
	    
	    
	    //delete
	    public boolean delete(Long sessionID) {
	        
	    	this.repo.deleteById(sessionID);
	        return !this.repo.existsById(sessionID);
	    }
	    
	   

}
