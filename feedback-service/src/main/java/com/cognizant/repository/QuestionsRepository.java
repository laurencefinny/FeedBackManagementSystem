package com.cognizant.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cognizant.model.Questions;

public interface QuestionsRepository extends ReactiveCrudRepository<Questions, Integer> {

	// @Query("select * from questions where id = ?queId")
	// Mono<Questions> findById(String queId);

}