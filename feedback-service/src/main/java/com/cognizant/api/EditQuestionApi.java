/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cognizant.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.entity.FeedbackQuestions;
import com.cognizant.model.Answers;
import com.cognizant.model.Questions;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-05T15:37:34.340+05:30[Asia/Calcutta]")
@Api(value = "Edit-question", description = "the Edit-question API")
@CrossOrigin("http://localhost:3000")
public interface EditQuestionApi {

	Logger log = LoggerFactory.getLogger(EditQuestionApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "Get  Question ", nickname = "getQuestions()", notes = "Get the Question and Answers for the Events", response = Questions.class, tags = {
			"Question and Answers", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Questions.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/Edit-question/{questionId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	default Mono<ResponseEntity<Questions>> getQuestion(
			@ApiParam(value = "", required = true) @PathVariable("questionId") Integer questionId) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Mono.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n}, {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n} ]",
							Questions.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default EditQuestionApi interface so no example is generated");
		}
		return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "Get  Question ", nickname = "getQuestions()", notes = "Get the Question and Answers for the Events", response = Questions.class, tags = {
			"Question and Answers", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Questions.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/Edit-question", produces = { "application/json" }, method = RequestMethod.GET)
	default Flux<ResponseEntity<Questions>> getAllQuestion(
			@ApiParam(value = "", required = true) @PathVariable("questionId") Integer questionId) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n}, {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n} ]",
							Questions.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default EditQuestionApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "Get  Answers ", nickname = "getAnswers()", notes = "Get  Answers for the Questions", response = Answers.class, tags = {
			"Question and Answers", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Answers.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/answers/{ansId}", produces = { "application/json" }, method = RequestMethod.GET)
	default Flux<ResponseEntity<Answers>> getAnswers(
			@ApiParam(value = "", required = true) @PathVariable("ansId") Integer questionId) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n}, {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n} ]",
							Answers.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default EditQuestionApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "Get Event", nickname = "getAllEvent", notes = "Get the Details of All Events", response = Questions.class, tags = {
			"Event", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Questions.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/all-questions", produces = { "application/json" }, method = RequestMethod.GET)
	default Flux<ResponseEntity<Questions>> getAllQuestions() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n}, {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n} ]",
							Questions.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default EditQuestionApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "Get  Question and Answers List", nickname = "getFeedbackQuestions()", notes = "Get the Question and Answers for the Events", response = Questions.class, responseContainer = "List", tags = {
			"Question and Answers", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Questions.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/FeedbackQuestions", produces = { "application/json" }, method = RequestMethod.GET)
	default Flux<ResponseEntity<FeedbackQuestions>> getFeedbackQuestions() {

		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n}, {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n} ]",
							FeedbackQuestions.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default EditQuestionApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));

	}

	@ApiOperation(value = "delete  Question and Answers", nickname = "removeQA", notes = "delete the Question and Answers for the Events", response = Questions.class, responseContainer = "List", tags = {
			"Question and Answers", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Questions.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/Edit-question/{questionId}", produces = {
			"application/json" }, method = RequestMethod.DELETE)
	default Mono<ResponseEntity<Questions>> removeQA(
			@ApiParam(value = "", required = true) @PathVariable("questionId") Integer questionId) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Mono.just(new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n}, {\r\n  \"question\" : \"question\",\r\n  \"answers\" : {\r\n    \"questions_id\" : 0,\r\n    \"answers\" : \"answers\"\r\n  },\r\n  \"fb_type\" : \"fb_type\"\r\n} ]",
							Questions.class), HttpStatus.NOT_IMPLEMENTED));
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default EditQuestionApi interface so no example is generated");
		}
		return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "", nickname = "role", notes = "assign the user role", response = Void.class, tags = {
			"fms login", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "role assigned successfully", response = Void.class),
			@ApiResponse(code = 404, message = "No user found") })
	@RequestMapping(value = "/Edit-question/{questionId}", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" })
	default Mono<ResponseEntity<Void>> updateQuestion(
			@ApiParam(value = "", required = true) @Valid @RequestBody Questions body,
			@PathVariable("questionId") Integer questionId) {

		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default RoleApi interface so no example is generated");
		}
		return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "", nickname = "role", notes = "assign the user role", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "role assigned successfully", response = Void.class),
			@ApiResponse(code = 404, message = "No Answers found") })
	@RequestMapping(value = "/Edit-answers/", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" })
	default Flux<ResponseEntity<Void>> updateAnswers(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<Answers> body) {

		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default RoleApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "", nickname = "role", notes = "assign the user role", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "role assigned successfully", response = Void.class),
			@ApiResponse(code = 404, message = "No Answers found") })
	@RequestMapping(value = "/Edit-addAnswers/", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" })
	default Flux<ResponseEntity<Void>> addAnswers(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<Answers> body) {

		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default RoleApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "", nickname = "role", notes = "assign the user role", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "role assigned successfully", response = Void.class),
			@ApiResponse(code = 404, message = "No Answers found") })
	@RequestMapping(value = "/deleteAllAnswers/", method = RequestMethod.DELETE, consumes = { "application/json" })
	default Flux<ResponseEntity<Void>> deleteAllAnswers(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<Answers> body) {

		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Flux.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default RoleApi interface so no example is generated");
		}
		return Flux.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "", nickname = "role", notes = "assign the user role", response = Void.class, tags = {
			"fms login", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "role assigned successfully", response = Void.class),
			@ApiResponse(code = 404, message = "No user found") })
	@RequestMapping(value = "/deleteQuestion/{questionId}", method = RequestMethod.DELETE, consumes = {
			"application/json" })
	default Mono<ResponseEntity<Void>> deleteQuestion(
			@ApiParam(value = "", required = true) @Valid @RequestBody Questions body,
			@PathVariable("questionId") Integer questionId) {

		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default RoleApi interface so no example is generated");
		}
		return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}
}
