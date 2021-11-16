package com.qa.springbootsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;

@Entity
public class WorkoutPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sessionID;
	
	@Column
	private String dayOfWeek;
	
	@ManyToMany
	private Excercise excercise;

}
