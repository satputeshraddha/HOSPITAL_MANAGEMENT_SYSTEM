package org.dnyanyog.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dnyanyog.dto.request.AddUserRequest;
import org.dnyanyog.dto.response.AddUserData;
import org.dnyanyog.dto.response.AddUserResponse;
import org.dnyanyog.dto.response.GetUserByPatientIdData;
import org.dnyanyog.dto.response.GetUserByPatientIdResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService 
{
	

	@Autowired
	AddUserResponse addUserResponse;

	@Autowired
	UserRepository userRepository;

	@Autowired
	Users user;

	
	
    private static final Logger logger = Logger.getLogger(UserService.class);

    


//	add User
	public ResponseEntity<AddUserResponse> addUser(AddUserRequest request) {
		
		addUserResponse = new AddUserResponse();
		addUserResponse.setData(new AddUserData());

		List<AddUserResponse.Error> validationErrors = new ArrayList();
		

		if (StringUtils.isEmpty(request.getName())) {
			logger.info(validationErrors);;
			validationErrors.add(new AddUserResponse.Error("User Name is Required"));
		}
		if (StringUtils.isEmpty(request.getEmail())) {
			logger.info(validationErrors);;
			validationErrors.add(new AddUserResponse.Error( "Email is required"));
		}
		
		if (StringUtils.isEmpty(request.getMobileNumber())) {
			logger.info(validationErrors);
			validationErrors.add(new AddUserResponse.Error( "Mobile Number is required"));
		}
		if (StringUtils.isEmpty(request.getRole())) {
			logger.info(validationErrors);
			validationErrors.add(new AddUserResponse.Error( "role  is required"));
		}

		if (StringUtils.isEmpty(request.getPassword())) {
			logger.info(validationErrors);
			validationErrors.add(new AddUserResponse.Error("Password is required"));
		}

		if (StringUtils.isEmpty(request.getConformPassword())) {
			logger.info(validationErrors);
			validationErrors.add(new AddUserResponse.Error("Confirm Password is required"));
		}
		
		if (!validationErrors.isEmpty()) {
			logger.info(validationErrors);
			AddUserResponse response = new AddUserResponse();
			response.setResponseCode(HttpStatus.BAD_REQUEST.value());
			response.setResponseMessage("Validation failed");
			response.setError(validationErrors);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		

		user = new Users();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setMobileNumber(request.getMobileNumber());
		user.setRole(request.getRole());
		user.setPassword(request.getPassword());
		user.setConformPassword(request.getConformPassword());
	

		user = userRepository.saveAndFlush(user);

		addUserResponse.setResponseCode(HttpStatus.CREATED.value());
		addUserResponse.setResponseMessage("User Added successfully");
		addUserResponse.getData().setPatientId(user.getPatientId());
		addUserResponse.getData().setName(user.getName());
		addUserResponse.getData().setEmail(user.getEmail());
		addUserResponse.getData().setPassword(user.getPassword());
		addUserResponse.getData().setConformPassword(user.getConformPassword());
	

		logger.info("User Added Successfully ");
		return ResponseEntity.status(HttpStatus.CREATED).body(addUserResponse);
		
		
	}




  public Object getUserResponseByPatientId(Long patientId)
  {

		Users user = userRepository.getById(patientId);

		if (user == null) {
			GetUserByPatientIdResponse response = new GetUserByPatientIdResponse();
			response.setResponseCode(HttpStatus.NOT_FOUND.value());
			response.setResponseMessage("User not found");
			logger.info("User not found ");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

		GetUserByPatientIdResponse response = new GetUserByPatientIdResponse();
		response.setResponseCode(HttpStatus.OK.value());
		response.setResponseMessage("User found");
		response.setData(new GetUserByPatientIdData());
		response.getData().setPatientId(user.getPatientId());
		response.getData().setName(user.getName());
		response.getData().setEmail(user.getEmail());
		response.getData().setRole(user.getRole());
		response.getData().setMobileNumber(user.getMobileNumber());
		response.getData().setPassword(user.getPassword());
		response.getData().setConformPassword(user.getConformPassword());
	
		logger.info("User found");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

  }



