package org.dnyanyog.service;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.dnyanyog.dto.request.LoginRequest;
import org.dnyanyog.dto.response.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class LoginService {
	
	
	@Autowired
	private UserRepository userRepository;
	private static final Logger logger = Logger.getLogger(LoginService.class);
	int failedLoginAttempt;

	@Transactional
	public ResponseEntity<LoginResponse> loginUser(LoginRequest request) {

		if (StringUtils.isEmpty(request.getMobileNumber())) {
			logger.info("Validation failed");
			return createErrorResponse(422, "Mobile Number is required", "N/A");
		}

		if (StringUtils.isEmpty(request.getPassword())) {
			logger.info("Validation failed");
			return createErrorResponse(422, "Password is required", "N/A");
		}
		Users user=userRepository(request.getMobileNumber());

		if (user == null) {
			logger.info("Account not found ");
			return createErrorResponse(404, "Account not found", "N/A");
		}

	

			int failedLoginAttempt = user.getFailedLoginAttempts() + 1;
			user.setFailedLoginAttempts(failedLoginAttempt);
			userRepository.saveAndFlush(user);
			logger.info("Invalid username or password. Failed login attempts: " + failedLoginAttempt);

			return createErrorResponse(401, "Invalid username or password", "N/A");
			
		}

		private Users userRepository(String mobileNumber) {
    // TODO Auto-generated method stub
    return null;
  }

    private ResponseEntity<LoginResponse> createErrorResponse(int code, String message, String role) {
      
		LoginResponse response = new LoginResponse();
		response.setResponseCode(code);
		response.setResponseMessage(message);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	
	
	private LoginResponse createSuccessResponse(LoginRequest request) {
		Users user = userRepository.findBymobileNumber(request.getMobileNumber());
		LoginResponse response = new LoginResponse();
		response.setResponseCode(HttpStatus.OK.value());
		response.setResponseMessage("Login successful");
		logger.info("Login successful ");
		return response;
	}

}
