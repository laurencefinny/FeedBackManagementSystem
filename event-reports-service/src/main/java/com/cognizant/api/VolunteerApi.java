/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cognizant.api;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.VolunteerRegistered;
import com.cognizant.model.VolunteerUnRegistered;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
@Api(value = "volunteer", description = "the volunteer API")
public interface VolunteerApi {

	Logger log = LoggerFactory.getLogger(VolunteerApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "Add  UnVolunteers", nickname = "addAllUnVolunteer", notes = "Add the UnRegisterd Volunteer Details", response = VolunteerUnRegistered.class, tags = {
			"Volunteer UnRegistered", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = VolunteerUnRegistered.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/volunteer/unreg", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default Flux<ResponseEntity<VolunteerUnRegistered>> addAllUnVolunteer(
			@ApiParam(value = "", required = true) @Valid @RequestBody VolunteerUnRegistered body) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"{\r\n  \"beneficiary_name\" : \"beneficiary_name\",\r\n  \"base_location\" : \"base_location\",\r\n  \"event_id\" : \"event_id\",\r\n  \"event_date\" : \"2000-01-23\",\r\n  \"employee_id\" : 0,\r\n  \"event_name\" : \"event_name\"\r\n}",
							VolunteerUnRegistered.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default VolunteerApi interface so no example is generated");
		}

		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "Add Volunteer", nickname = "addAllVolunteer", notes = "Add the Registerd Volunteer Details (Participted & NonParticipted )", response = VolunteerRegistered.class, tags = {
			"Volunteer Registered", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = VolunteerRegistered.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/volunteer/reg", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default Flux<ResponseEntity<VolunteerRegistered>> addAllVolunteer(
			@ApiParam(value = "", required = true) @Valid @RequestBody VolunteerRegistered body) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"{\r\n  \"beneficiary_name\" : \"beneficiary_name\",\r\n  \"base_location\" : \"base_location\",\r\n  \"event_id\" : \"event_id\",\r\n  \"event_date\" : \"2000-01-23\",\r\n  \"employee_id\" : 0,\r\n  \"event_name\" : \"event_name\"\r\n}",
							VolunteerRegistered.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default VolunteerApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "get UnVolunteer", nickname = "getAllUnRegVolunteer", notes = "Add the UnRegisterd Volunteer Details", response = VolunteerUnRegistered.class, responseContainer = "List", tags = {
			"Volunteer UnRegistered", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = VolunteerUnRegistered.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/volunteer/unreg", produces = { "application/json" }, method = RequestMethod.GET)
	default Flux<ResponseEntity<VolunteerUnRegistered>> getAllUnRegVolunteer() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"beneficiary_name\" : \"beneficiary_name\",\r\n  \"base_location\" : \"base_location\",\r\n  \"event_id\" : \"event_id\",\r\n  \"event_date\" : \"2000-01-23\",\r\n  \"employee_id\" : 0,\r\n  \"event_name\" : \"event_name\"\r\n}, {\r\n  \"beneficiary_name\" : \"beneficiary_name\",\r\n  \"base_location\" : \"base_location\",\r\n  \"event_id\" : \"event_id\",\r\n  \"event_date\" : \"2000-01-23\",\r\n  \"employee_id\" : 0,\r\n  \"event_name\" : \"event_name\"\r\n} ]",
							VolunteerUnRegistered.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default VolunteerApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "Get Volunteers", nickname = "getAllVolunteer", notes = "get the Registerd Volunteer Details (Participted & NonParticipted )", response = VolunteerRegistered.class, tags = {
			"Volunteer Registered", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = VolunteerRegistered.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/volunteer/reg", produces = { "application/json" }, method = RequestMethod.GET)
	default Flux<ResponseEntity<VolunteerRegistered>> getAllVolunteer() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"beneficiary_name\" : \"beneficiary_name\",\r\n  \"base_location\" : \"base_location\",\r\n  \"event_id\" : \"event_id\",\r\n  \"event_date\" : \"2000-01-23\",\r\n  \"employee_id\" : 0,\r\n  \"event_name\" : \"event_name\"\r\n}, {\r\n  \"beneficiary_name\" : \"beneficiary_name\",\r\n  \"base_location\" : \"base_location\",\r\n  \"event_id\" : \"event_id\",\r\n  \"event_date\" : \"2000-01-23\",\r\n  \"employee_id\" : 0,\r\n  \"event_name\" : \"event_name\"\r\n} ]",
							VolunteerRegistered.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default VolunteerApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

}
