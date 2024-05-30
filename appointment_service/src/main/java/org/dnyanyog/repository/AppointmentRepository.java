package org.dnyanyog.repository;

import java.util.List;

import org.dnyanyog.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
@RestController
public interface AppointmentRepository extends JpaRepository<Appointment, String>{
	
	
	List<Appointment> findByPatientId(String patientId);
	Appointment findByAppointmentId(String appointmentId);
	Appointment deleteAppointmentByAppointmentId(String appointmentId);
  boolean existsByExaminationDateAndAppointmentTime(String examinationDate, String appointmentTime);
}
