package com.qa.springbootsw.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootsw.domain.WorkoutPlan;
import com.qa.springbootsw.services.WorkoutService;

@RestController
	@RequestMapping("/WorkoutPlan") // http://localhost:9000/WorkoutPlan/...
public class WorkoutController {
	
	private WorkoutService service;
	// Constructor Injection
		public WorkoutController(WorkoutService service) {
			this.service = service;
		}
	

	 @PostMapping("/create")
	 public ResponseEntity<WorkoutPlan> addWorkout(@RequestBody WorkoutPlan workoutplan) {
		 return new ResponseEntity<WorkoutPlan>(this.service.create(workoutplan), HttpStatus.CREATED);
	 }
	 
	// Read // return the whole list
		@GetMapping("/getAll")
		public ResponseEntity<List<WorkoutPlan>> getAll() {
			return new ResponseEntity<List<WorkoutPlan>>(this.service.getAll(),HttpStatus.OK);
		}
		
		@GetMapping("/getOne/{id}")
		public ResponseEntity<WorkoutPlan> getOne(@PathVariable Long id) {
			return new ResponseEntity<WorkoutPlan>(this.service.getOne(id),HttpStatus.OK);
		}
		
		// Update
		@PutMapping("/update/{id}")
		public ResponseEntity<WorkoutPlan> update(@PathVariable Long id, @RequestBody WorkoutPlan workoutPlan) {
			return new ResponseEntity<WorkoutPlan>(this.service.update(id, workoutPlan), HttpStatus.ACCEPTED);
		}
		
		//delete
		  @DeleteMapping("/delete/{id}")
		    public ResponseEntity<WorkoutPlan> removeExcercise(@PathVariable Long id) {
		        // Remove account and return it
			  return this.service.delete(id) ? new ResponseEntity<WorkoutPlan>(HttpStatus.NO_CONTENT) 
						: new ResponseEntity<WorkoutPlan>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  
		
	 
}
