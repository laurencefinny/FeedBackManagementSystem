package com.cognizant.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.Event;
import com.cognizant.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
@Controller
public class EventApiController implements EventApi {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public EventApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
	private EventRepository eventRepository;

	@Override
	public Flux<ResponseEntity<Event>> getAllEvent() {

		return eventRepository.findAll().map(events -> ResponseEntity.ok().body(events))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

	@Override
	public Mono<ResponseEntity<Event>> getEventById(
			@ApiParam(value = "", required = true) @PathVariable("eventId") String eventId) {
		return eventRepository.findByEventId(eventId).map(event -> ResponseEntity.ok().body(event))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();
	}

	@Override
	public Flux<ResponseEntity<Event>> getEventByEmpId(
			@ApiParam(value = "", required = true) @PathVariable("empId") String empId) {
		return eventRepository.findByEmpId(empId).map(event -> ResponseEntity.ok().body(event))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();
	}
}
