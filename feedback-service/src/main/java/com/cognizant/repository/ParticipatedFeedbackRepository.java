package com.cognizant.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.ParticipatedFeedBack;

import reactor.core.publisher.Flux;

@Repository
public interface ParticipatedFeedbackRepository extends ReactiveCrudRepository<ParticipatedFeedBack, Long> {

	@Query("select rating,dislike,likes from participated where event_event_id = :eventId")
	public Flux<ParticipatedFeedBack> findByEventId(String eventId);

}
