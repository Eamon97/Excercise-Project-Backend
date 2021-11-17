package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qa.springbootsw.domain.WorkoutPlan;

public interface WorkoutRepo extends JpaRepository<WorkoutPlan, Long> {

}
