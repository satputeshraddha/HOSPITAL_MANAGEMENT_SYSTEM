package org.dnyanyog.controller;

import org.dnyanyog.dto.request.PatientRequest;
import org.dnyanyog.dto.response.PatientResponse;
import org.dnyanyog.repository.PatientRepository;
import org.dnyanyog.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	
	
	@Autowired
	PatientService patientservice;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	PatientResponse patientResponse;

	@PostMapping(path = "api/v1/Patient/add")
	public ResponseEntity<PatientResponse> addPatient(@RequestBody PatientRequest patientRequest,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		try {
			ResponseEntity<PatientResponse> responseEntity = patientservice.addPatientInfo(patientRequest);
			return responseEntity;
		} catch (Exception e) {

			patientResponse.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			patientResponse.setResponseMessage("Internal server error occurred");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(patientResponse);
		}
	}
	
	@DeleteMapping(path = "api/v1/deletePatient/{patientId}")
	public ResponseEntity<PatientResponse> deletePatient(@PathVariable Long patientId) {
		PatientResponse patientResponse = patientservice.deletePatientById(patientId);
		return ResponseEntity.status(patientResponse.getResponseCode()).body(patientResponse);
	}
	@GetMapping(path = "api/v1/patient/{patientId}")
	public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long patientId) {
		try {
			ResponseEntity<PatientResponse> responseEntity = patientservice.getPatientById(patientId);
			return responseEntity;
		} catch (Exception e) {
			patientResponse = new PatientResponse();
			patientResponse.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			patientResponse.setResponseMessage("Internal server error occurred");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(patientResponse);
		}
	}

}
