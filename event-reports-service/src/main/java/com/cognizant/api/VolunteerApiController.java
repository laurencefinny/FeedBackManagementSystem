package com.cognizant.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.model.VolunteerRegistered;
import com.cognizant.model.VolunteerUnRegistered;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
@Controller
public class VolunteerApiController implements VolunteerApi {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public VolunteerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
	private DatabaseClient databaseClient;

	@Override
	public Flux<ResponseEntity<VolunteerRegistered>> getAllVolunteer() {
		return databaseClient.execute("select * from volunteer_reg").as(VolunteerRegistered.class).fetch().all()
				.map(dashboard -> ResponseEntity.ok(dashboard))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

	@Override
	public Flux<ResponseEntity<VolunteerRegistered>> addAllVolunteer(
			@ApiParam(value = "", required = true) @Valid @RequestBody VolunteerRegistered body) {
		return null;

	}

	@Override
	public Flux<ResponseEntity<VolunteerUnRegistered>> getAllUnRegVolunteer() {
		return databaseClient.execute("select * from volunteer_unreg").as(VolunteerUnRegistered.class).fetch().all()
				.map(dashboard -> ResponseEntity.ok(dashboard))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

	@Override
	public Flux<ResponseEntity<VolunteerUnRegistered>> addAllUnVolunteer(
			@ApiParam(value = "", required = true) @Valid @RequestBody VolunteerUnRegistered body) {
		return null;

	}
}
