package com.qa.springbootsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Excercise {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long excerciseID;
	
	@Column(nullable = false)
	private String excerciseName;
	
	@Column(nullable = false)
	private String muscleTargeted;
	
	

}
