package com.cognizant.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.Feedback;
import com.cognizant.repository.NotparticipatedFeedbackRepository;
import com.cognizant.repository.ParticipatedFeedbackRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-05T15:37:34.340+05:30[Asia/Calcutta]")
@Controller
public class FeedbacksApiController implements FeedbacksApi {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public FeedbacksApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Autowired
	private ParticipatedFeedbackRepository participatedFeedbackRepository;

	@Autowired
	private NotparticipatedFeedbackRepository notparticipatedFeedbackRepository;

	public Flux<ResponseEntity<Feedback>> getFeedback(
			@ApiParam(value = "", required = true) @PathVariable("eventId") String eventId) {
		Feedback feedback = new Feedback();
		feedback.setParticipatedFeedBack(participatedFeedbackRepository.findByEventId(eventId).collectList().block());
		feedback.setNotParticipated(
				notparticipatedFeedbackRepository.findNotparticipatedByEventId(eventId).collectList().block());
		feedback.setUnregistered(
				notparticipatedFeedbackRepository.findUnRegisteredByEventId(eventId).collectList().block());
		Flux.just(feedback);

		return Flux.just(feedback).map(feedbacks -> ResponseEntity.ok().body(feedbacks))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

}
