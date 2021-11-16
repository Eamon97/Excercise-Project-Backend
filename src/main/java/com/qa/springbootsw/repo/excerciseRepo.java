package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springbootsw.domain.Excercise;

public interface excerciseRepo extends JpaRepository<Excercise, Long> {

}
