package com.qa.springbootsw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springbootsw.domain.Excercise;

@Repository
public interface ExcerciseRepo extends JpaRepository<Excercise, Long> {

}
