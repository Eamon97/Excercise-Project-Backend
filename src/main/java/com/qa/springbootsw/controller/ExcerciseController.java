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

import com.qa.springbootsw.domain.Excercise;
import com.qa.springbootsw.services.ExcerciseService;




@RestController
	@RequestMapping("/Excercise") // http://localhost:9000/Excercise/...
public class ExcerciseController {
	
	
		
private ExcerciseService service;

	// Constructor Injection
			public ExcerciseController(ExcerciseService service) {
				this.service = service;
			}
		
		
	//Create 	
		
		 @PostMapping("/create")
		 public ResponseEntity<Excercise> addExcercise(@RequestBody Excercise excercise) {
			 return new ResponseEntity<Excercise>(this.service.create(excercise), HttpStatus.CREATED);
		 }
		 
	// Read whole list of excercises
		 
			@GetMapping("/getAll")
			public ResponseEntity<List<Excercise>> getAll() {
				return new ResponseEntity<List<Excercise>>(this.service.getAll(),HttpStatus.OK);
			}
			
	//Read
			@GetMapping("/getOne/{excerciseID}")
			public ResponseEntity<Excercise> getOne(@PathVariable Long excerciseID) {
				return new ResponseEntity<Excercise>(this.service.getOne(excerciseID),HttpStatus.OK);
			}
			
	// Update
			@PutMapping("/update/{excerciseID}")
			public ResponseEntity<Excercise> update(@PathVariable Long excerciseID, @RequestBody Excercise excercise) {
				return new ResponseEntity<Excercise>(this.service.update(excerciseID, excercise), HttpStatus.ACCEPTED);
			}
			
	//Delete
			  @DeleteMapping("/delete/{excerciseID}")
			    public ResponseEntity<Excercise> removeExcercise(@PathVariable Long excerciseID) {
			       
	// Remove account and return it
				  return this.service.delete(excerciseID) ? new ResponseEntity<Excercise>(HttpStatus.NO_CONTENT) 
							: new ResponseEntity<Excercise>(HttpStatus.INTERNAL_SERVER_ERROR);
			    }
			  
			
		 

}
