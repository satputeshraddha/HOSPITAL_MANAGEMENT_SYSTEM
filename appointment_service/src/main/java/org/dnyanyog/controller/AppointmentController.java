package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.request.AppointmentRequest;
import org.dnyanyog.dto.response.AppointmentResponse;
import org.dnyanyog.dto.response.GetAppointmentByIdResponse;
import org.dnyanyog.dto.response.GetAppointmentsResponse;
import org.dnyanyog.dto.response.SearchAppointmentByAppointmentIdResponse;
import org.dnyanyog.dto.response.SearchAppointmentByPatientIdResponse;
import org.dnyanyog.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService service;
	
	@PostMapping(path = "api/v1/appointment/add")
	public ResponseEntity<AppointmentResponse> addAppointment(@RequestBody AppointmentRequest appointmentRequest) 
	{

		return service.addAppointment(appointmentRequest);
	}
		

		@GetMapping(path = "api/v1/appointment/{appointmentId}")
		public ResponseEntity<SearchAppointmentByAppointmentIdResponse> searchAppointmentByAppointmentId(@PathVariable String appointmentId) {

			return service.searchAppointmentByAppointmentId(appointmentId);
		}

		@GetMapping(path = "api/v1/appointment/{patientId}")
		public ResponseEntity<List<SearchAppointmentByPatientIdResponse>> SearchAppointmentByPatientId(@PathVariable String patientId) {

			return service. SearchAppointmentByPatientId(patientId);
		}

}
