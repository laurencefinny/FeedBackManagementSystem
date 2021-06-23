package com.cognizant.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.EventReport;
import com.cognizant.repository.EventReportRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
@Controller
public class EventReportApiController implements EventReportApi {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public EventReportApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
	private EventReportRepository eventReportRepository;

	@Autowired
	private DatabaseClient databaseClient;

	@Override
	public Flux<ResponseEntity<EventReport>> getAllEventReport() {

		return eventReportRepository.findAll().map(eventReports -> ResponseEntity.ok().body(eventReports))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

	@Override
	public Flux<ResponseEntity<EventReport>> getEventReportById(
			@ApiParam(value = "", required = true) @PathVariable("eventReportId") String eventReportId) {
		return eventReportRepository.findByEventId(eventReportId)
				.map(eventReport -> ResponseEntity.ok().body(eventReport))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();
	}

	@Override
	public Flux<ResponseEntity<EventReport>> getUser() {
		return databaseClient.execute("SELECT employee_id,employee_name FROM fms.event_report").as(EventReport.class)
				.fetch().all().map(dashboard -> ResponseEntity.ok(dashboard))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();

	}

	@Override
	public Flux<ResponseEntity<EventReport>> getEventReportByEmpId(
			@ApiParam(value = "", required = true) @PathVariable("empId") String empId) {
		return eventReportRepository.findByEventEmpId(empId).map(event -> ResponseEntity.ok().body(event))
				.defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).log();
	}
}
