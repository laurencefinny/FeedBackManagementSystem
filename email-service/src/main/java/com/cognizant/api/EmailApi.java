/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cognizant.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.entity.Email;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
@Api(value = "Email", description = "the Email API")
public interface EmailApi {

	Logger log = LoggerFactory.getLogger(Email.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful Operation", response = Email.class),
			@ApiResponse(code = 400, message = "Invalid status value"),
			@ApiResponse(code = 404, message = "Page not found") })
	@RequestMapping(value = "/sendEventEmail/{eventId}", produces = { "application/xml",
			"application/json" }, method = RequestMethod.GET)
	Mono<Boolean> sendEventEmail(@ApiParam(value = "email", required = true) @PathVariable("eventId") Integer eventId);

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful Operation", response = Email.class),
			@ApiResponse(code = 400, message = "Invalid status value"),
			@ApiResponse(code = 404, message = "Page not found") })
	@RequestMapping(value = "/sendEmail", produces = { "application/xml",
			"application/json" }, method = RequestMethod.GET)
	Mono<Boolean> sendEmail();

}
