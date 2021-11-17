package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springbootsw.domain.Excercise;

public interface ExcerciseRepo extends JpaRepository<Excercise, Long> {

}
