package com.qa.springbootsw.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


@Component
@Entity
public class WorkoutPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sessionID;
	
	@Column
	private String dayOfWeek;
	
	
	@OneToMany(mappedBy="workoutPlan")
	private List<Excercise> excercises;

	
	
	public WorkoutPlan() {	}
	
public WorkoutPlan(Long sessionID, String dayOfWeek, List<Excercise> excercises) {
		super();
		this.sessionID = sessionID;
		this.dayOfWeek = dayOfWeek;
		this.excercises = excercises;
	}

	public WorkoutPlan(String dayOfWeek, List<Excercise> excercises) {
		this.dayOfWeek = dayOfWeek;
		this.excercises = excercises;
	}

	
	public Long getSessionID() {
		return sessionID;
	}

	public void setSessionID(Long sessionID) {
		this.sessionID = sessionID;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Excercise> getExcercises() {
		return excercises;
	}

	public void setExcercises(List<Excercise> excercises) {
		this.excercises = excercises;
	}

	@Override
	public String toString() {
		return "WorkoutPlan [sessionID=" + sessionID + ", dayOfWeek=" + dayOfWeek + ", excercises=" + excercises + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((excercises == null) ? 0 : excercises.hashCode());
		result = prime * result + ((sessionID == null) ? 0 : sessionID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkoutPlan other = (WorkoutPlan) obj;
		if (dayOfWeek == null) {
			if (other.dayOfWeek != null)
				return false;
		} else if (!dayOfWeek.equals(other.dayOfWeek))
			return false;
		if (excercises == null) {
			if (other.excercises != null)
				return false;
		} else if (!excercises.equals(other.excercises))
			return false;
		if (sessionID == null) {
			if (other.sessionID != null)
				return false;
		} else if (!sessionID.equals(other.sessionID))
			return false;
		return true;
	}
	
	
	
	

}
