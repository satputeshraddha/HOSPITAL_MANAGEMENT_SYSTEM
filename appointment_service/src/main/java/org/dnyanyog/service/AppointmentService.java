package org.dnyanyog.service;

import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.dto.request.AppointmentRequest;

import org.dnyanyog.dto.response.AppointmentData;
import org.dnyanyog.dto.response.AppointmentResponse;

import org.dnyanyog.dto.response.SearchAppointmentByAppointmentIdData;
import org.dnyanyog.dto.response.SearchAppointmentByAppointmentIdResponse;
import org.dnyanyog.dto.response.SearchAppointmentByPatientIdData;
import org.dnyanyog.dto.response.SearchAppointmentByPatientIdResponse;

import org.dnyanyog.entity.Appointment;
import org.dnyanyog.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	
	
	@Autowired
	AppointmentRepository appRepo;
	@Autowired
	Appointment appointment;
	@Autowired
	AppointmentResponse appointmentResponse;
	
	@Autowired
	AppointmentData appointmentData;
	
	public ResponseEntity<AppointmentResponse> addAppointment(AppointmentRequest request) 
	{

		appointmentResponse = new AppointmentResponse();
		appointmentResponse.setData(new AppointmentData());
		appointment = new Appointment();

		if (appRepo.existsByExaminationDateAndAppointmentTime(request.getExaminationDate(),
				request.getAppointmentTime())) {
			appointmentResponse.setResponseCode(HttpStatus.CONFLICT.value());
			appointmentResponse.setResponseMessage("Appointment with the same date and time already exists.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(appointmentResponse);
		}

		appointment.setExaminationDate(request.getExaminationDate());
		appointment.setAppointmentTime(request.getAppointmentTime());
		appointment.setPatientId(request.getPatientId());
		appointment.setPatientNameInEnglish(request.getPatientNameInEnglish());
		appointment.setAppointmentId(request.getAppointmentId());
		appointment = appRepo.saveAndFlush(appointment);

		appointmentResponse.setResponseCode(HttpStatus.CREATED.value());
		appointmentResponse.setResponseMessage("Appointment Scheduled");
		appointmentResponse.getData().setAppointmentId(appointment.getAppointmentId());
		appointmentResponse.getData().setAppointmentTime(appointment.getAppointmentTime());
		appointmentResponse.getData().setPatientNameInEnglish(appointment.getPatientNameInEnglish());
		appointmentResponse.getData().setExaminationDate(appointment.getExaminationDate());
		appointmentResponse.getData().setPatientId(appointment.getPatientId());

		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponse);

	}

	


	public ResponseEntity<SearchAppointmentByAppointmentIdResponse> searchAppointmentByAppointmentId(String appointmentId) {

		Appointment appointment = appRepo.findByAppointmentId(appointmentId);

		if (appointment == null) {
			SearchAppointmentByAppointmentIdResponse response = new SearchAppointmentByAppointmentIdResponse();
			response.setResponseCode(HttpStatus.NOT_FOUND.value());
			response.setResponseMessage("Appointment not found");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

		SearchAppointmentByAppointmentIdResponse response = new SearchAppointmentByAppointmentIdResponse();
		response.setResponseCode(HttpStatus.OK.value());
		response.setResponseMessage("Appointment found");
		response.setData(new SearchAppointmentByAppointmentIdData());
		response.getData().setAppointmentId(appointment.getAppointmentId());
		response.getData().setAppointmentTime(appointment.getAppointmentTime());
		response.getData().setExaminationDate(appointment.getExaminationDate());
		response.getData().setPatientId(appointment.getPatientId());
		response.getData().setPatientNameInEnglish(appointment.getPatientNameInEnglish());
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}



	

	public ResponseEntity<List<SearchAppointmentByPatientIdResponse>> SearchAppointmentByPatientId(String patientId) {
		

		List<Appointment> appointment = appRepo.findByPatientId(patientId);
		List<SearchAppointmentByPatientIdResponse> appointmentDataList = new ArrayList<>();
		
		for (Appointment appointmentInfo : appointment) {
			SearchAppointmentByPatientIdResponse response = new SearchAppointmentByPatientIdResponse();
			response.setResponseCode(HttpStatus.OK.value());
			response.setResponseMessage("Appointment found");
			response.setData(SearchAppointmentByPatientIdData());
			
			response.getData().setAppointmentId(appointmentInfo.getAppointmentId());
			response.getData().setAppointmentTime(appointmentInfo.getAppointmentTime());
			response.getData().setPatientId(appointmentInfo.getPatientId());
			response.getData().setExaminationDate(appointmentInfo.getExaminationDate());
			response.getData().setPatientNameInEnglish(appointmentInfo.getPatientNameInEnglish());
			appointmentDataList.add(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(appointmentDataList);

		
	}




  private SearchAppointmentByPatientIdData SearchAppointmentByPatientIdData() {
    // TODO Auto-generated method stub
    return null;
  }




  	
}