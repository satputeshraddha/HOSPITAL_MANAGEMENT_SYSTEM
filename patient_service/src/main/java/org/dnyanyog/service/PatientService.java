package org.dnyanyog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.dnyanyog.dto.request.PatientRequest;
import org.dnyanyog.dto.response.PatientData;
import org.dnyanyog.dto.response.PatientResponse;
import org.dnyanyog.entity.PatientInfo;
import org.dnyanyog.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class PatientService {
	
	

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	PatientInfo patientInfo;

	@Autowired
	PatientResponse patientResponse;

	@Autowired
	PatientData patientData;

	public ResponseEntity<PatientResponse> addPatientInfo(PatientRequest request) {

		patientResponse = new PatientResponse();
		patientResponse.setData(new PatientData());

		if (patientRepository.existsByPatientMobile(request.getPatientMobile())) {
			
			patientResponse=new PatientResponse();
			patientResponse.setResponseCode(HttpStatus.UNAUTHORIZED.value());
			patientResponse.setResponseMessage("MobileNumber Alredy Exist");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(patientResponse);
				 
		}

		List<PatientResponse.ValidationError> validationErrors = Stream.of(
				validateField(StringUtils::isEmpty, request.getPatientNameEnglish(), "patientNameEnglish",
						"Patient name (English) is required"),
				validateField(StringUtils::isEmpty, request.getPatientNameMarathi(), "patientNameMarathi",
						"Patient name (Marathi) is required"),
				validateField(StringUtils::isEmpty, request.getPatientGender(), "patientGender",
						"Patient Gender is required"),
				validateField(StringUtils::isEmpty, request.getPatientMobile(), "patientMobile",
						"Patient Mobile is required"),
				validateField(StringUtils::isEmpty, request.getAddress(), "address", "Patient Address is required"),
				validateField(date -> date == null,
						request.getBirthDate() != null ? request.getBirthDate().toString() : null, "birthDate",
						"Patient BirthDate is required"),
				validateField(date -> date == null,
						request.getFirstExaminationDate() != null ? request.getFirstExaminationDate().toString() : null, "firstExaminationDate",
						"firstExaminationDate is required")
				

		).filter(Objects::nonNull).collect(Collectors.toList());

		if (!validationErrors.isEmpty()) {
			patientResponse = new PatientResponse();
			patientResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
			patientResponse.setResponseMessage("validation failed");
			patientResponse.setErrors(validationErrors);
			return ResponseEntity.badRequest().body(patientResponse);
		}

		patientInfo = new PatientInfo();

		patientInfo.setPatientNameEnglish(request.getPatientNameEnglish());
		patientInfo.setPatientNameMarathi(request.getPatientNameMarathi());
		patientInfo.setPatientGender(request.getPatientGender());
		patientInfo.setPatientMobile(request.getPatientMobile());
		patientInfo.setAddress(request.getAddress());
		patientInfo.setBirthDate(request.getBirthDate());
		patientInfo.setFirstExaminationDate(request.getFirstExaminationDate());

		patientInfo = patientRepository.save(patientInfo);

		patientResponse.setResponseCode(HttpStatus.CREATED.value());
		patientResponse.setResponseMessage("Patient added successFully");

		patientResponse.getData().setPatientId(patientInfo.getPatientId());
		patientResponse.getData().setPatientNameEnglish(patientInfo.getPatientNameEnglish());
		patientResponse.getData().setPatientNameMarathi(patientInfo.getPatientNameMarathi());
		patientResponse.getData().setPatientGender(patientInfo.getPatientGender());
		patientResponse.getData().setPatientMobile(patientInfo.getPatientMobile());
		patientResponse.getData().setAddress(patientInfo.getAddress());
		patientResponse.getData().setBirthDate(request.getBirthDate());
		patientResponse.getData().setFirstExaminationDate(patientInfo.getFirstExaminationDate());
		patientResponse.getData().setPatientStatus(patientInfo.getPatientStatus());
		

		return ResponseEntity.status(HttpStatus.CREATED).body(patientResponse);

	}

	private PatientResponse.ValidationError validateField(Predicate<String> condition, String value, String field,
			String message) {
		if (condition.test(value)) {
			return new PatientResponse.ValidationError(field, message);
		}
		return null;
	}

	public PatientResponse deletePatientById(Long patientId) {
		Optional<PatientInfo> existingPatient = patientRepository.findByPatientId(patientId);

		PatientResponse patientResponse = new PatientResponse();

		if (existingPatient.isPresent()) {
			PatientInfo patientToDelete = existingPatient.get();
			patientToDelete.setPatientStatus("INACTIVE");
			patientRepository.save(patientToDelete);

			patientResponse.setResponseCode(HttpStatus.OK.value());
			patientResponse.setResponseMessage("Patient marked as INACTIVE");
		} else {
			patientResponse.setResponseCode(HttpStatus.NOT_FOUND.value());
			patientResponse.setResponseMessage("Patient with the provided ID not found");
		}

		return patientResponse;
	}



	public ResponseEntity<PatientResponse> getPatientById(Long patientId) {
		Optional<PatientInfo> patient = patientRepository.findByPatientId(patientId);
		if (patient.isPresent()) {
			PatientInfo patientInfo = patient.get();
			PatientData patientData = new PatientData();
			patientData.setPatientId(patientInfo.getPatientId());
			patientData.setPatientNameEnglish(patientInfo.getPatientNameEnglish());
			patientData.setPatientNameMarathi(patientInfo.getPatientNameMarathi());
			patientData.setPatientMobile(patientInfo.getPatientMobile());
			patientData.setPatientGender(patientInfo.getPatientGender());
			patientData.setAddress(patientInfo.getAddress());
			patientData.setBirthDate(patientInfo.getBirthDate());
			patientData.setFirstExaminationDate(patientInfo.getFirstExaminationDate());
			patientData.setPatientStatus(patientInfo.getPatientStatus());

			patientResponse = new PatientResponse();
			patientResponse.setResponseCode(HttpStatus.OK.value());
			patientResponse.setResponseMessage("Success");
			patientResponse.setData(patientData);

			return ResponseEntity.status(HttpStatus.OK).body(patientResponse);
		} else {
			patientResponse = new PatientResponse();
			patientResponse.setResponseCode(HttpStatus.NOT_FOUND.value());
			patientResponse.setResponseMessage("Patient is not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patientResponse);
		}
	}

	
	

}
