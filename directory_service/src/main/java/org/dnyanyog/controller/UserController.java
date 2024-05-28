package org.dnyanyog.controller;

import org.dnyanyog.dto.request.AddUserRequest;
import org.dnyanyog.dto.response.AddUserResponse;
import org.dnyanyog.dto.response.GetUserByPatientIdResponse;
import org.dnyanyog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController 
{
	
	 
	@Autowired
	UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@PostMapping(path = "api/v1/directory/add")
	public ResponseEntity<AddUserResponse> addUser(@RequestBody @Valid AddUserRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			AddUserResponse errorResponse = new AddUserResponse();
			errorResponse.setResponseCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
			errorResponse.setResponseMessage("Validation failed");
			logger.info("Validation failed");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
		}

		ResponseEntity<AddUserResponse> response = userService.addUser(request);
		return response;
	}
	@GetMapping(path = "api/v1/directory/{patientId}")
	public ResponseEntity<GetUserByPatientIdResponse> getUserByPatientId(@PathVariable Long patientId) {
		logger.info("Get User details");
		return (ResponseEntity<GetUserByPatientIdResponse>) userService.getUserResponseByPatientId(patientId);
	}
	


}
