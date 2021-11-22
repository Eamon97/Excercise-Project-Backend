package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springbootsw.domain.WorkoutPlan;

@Repository
public interface WorkoutRepo extends JpaRepository<WorkoutPlan, Long> {

}
