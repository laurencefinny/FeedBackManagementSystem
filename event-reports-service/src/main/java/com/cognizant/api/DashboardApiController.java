package com.cognizant.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.entity.Dashboard;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
@Controller
public class DashboardApiController implements DashboardApi {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public DashboardApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
	public Mono<ResponseEntity<Dashboard>> getDashboard() {
		return databaseClient
				.execute(
						"select count(*) as total_events ,sum(lives_impacted) as lives_impacted, sum(total_no_of_volunteers) as total_volunteers , sum(total_no_of_volunteers) as total_participants from event")
				.as(Dashboard.class).fetch().first().map(dashboard -> ResponseEntity.ok().body(dashboard))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

	@Override
	public Mono<ResponseEntity<Dashboard>> getDashboardUser(
			@ApiParam(value = "", required = true) @PathVariable("userId") String userId) {
		System.err.println(userId);
		return databaseClient
				.execute(
						"select count(*) as total_events ,sum(lives_impacted) as lives_impacted, sum(total_no_of_volunteers) as total_volunteers , sum(total_no_of_volunteers) as total_participants from event WHERE poc_id = "
								+ userId)
				.as(Dashboard.class).fetch().first().map(dashboard -> ResponseEntity.ok().body(dashboard))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

}
