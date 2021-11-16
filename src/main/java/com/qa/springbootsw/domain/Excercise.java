package com.qa.springbootsw.domain;

import java.util.Objects;

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
	
	@Column(nullable = false)
	private int noOfReps;
	
	@Column(nullable = false)
	private int noOfSets;

	public Excercise() {
		super();
	}

	public Excercise(long excerciseID, String excerciseName, String muscleTargeted, int noOfReps, int noOfSets) {
		super();
		this.excerciseID = excerciseID;
		this.excerciseName = excerciseName;
		this.muscleTargeted = muscleTargeted;
		this.noOfReps = noOfReps;
		this.noOfSets = noOfSets;
	}

	public Excercise(String excerciseName, String muscleTargeted, int noOfReps, int noOfSets) {
		super();
		this.excerciseName = excerciseName;
		this.muscleTargeted = muscleTargeted;
		this.noOfReps = noOfReps;
		this.noOfSets = noOfSets;
	}

	public long getExcerciseID() {
		return excerciseID;
	}

	public void setExcerciseID(long excerciseID) {
		this.excerciseID = excerciseID;
	}

	public String getExcerciseName() {
		return excerciseName;
	}

	public void setExcerciseName(String excerciseName) {
		this.excerciseName = excerciseName;
	}

	public String getMuscleTargeted() {
		return muscleTargeted;
	}

	public void setMuscleTargeted(String muscleTargeted) {
		this.muscleTargeted = muscleTargeted;
	}

	public int getNoOfReps() {
		return noOfReps;
	}

	public void setNoOfReps(int noOfReps) {
		this.noOfReps = noOfReps;
	}

	public int getNoOfSets() {
		return noOfSets;
	}

	public void setNoOfSets(int noOfSets) {
		this.noOfSets = noOfSets;
	}

	@Override
	public String toString() {
		return "Excercise [excerciseID=" + excerciseID + ", excerciseName=" + excerciseName + ", muscleTargeted="
				+ muscleTargeted + ", noOfReps=" + noOfReps + ", noOfSets=" + noOfSets + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (excerciseID ^ (excerciseID >>> 32));
		result = prime * result + ((excerciseName == null) ? 0 : excerciseName.hashCode());
		result = prime * result + ((muscleTargeted == null) ? 0 : muscleTargeted.hashCode());
		result = prime * result + noOfReps;
		result = prime * result + noOfSets;
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
		Excercise other = (Excercise) obj;
		if (excerciseID != other.excerciseID)
			return false;
		if (excerciseName == null) {
			if (other.excerciseName != null)
				return false;
		} else if (!excerciseName.equals(other.excerciseName))
			return false;
		if (muscleTargeted == null) {
			if (other.muscleTargeted != null)
				return false;
		} else if (!muscleTargeted.equals(other.muscleTargeted))
			return false;
		if (noOfReps != other.noOfReps)
			return false;
		if (noOfSets != other.noOfSets)
			return false;
		return true;
	}

	
	
	
	
	
	
	
	

}
