package org.dnyanyog.repository;

import java.util.Optional;

import org.dnyanyog.entity.PatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientInfo,Long>{

	 Optional<PatientInfo> findByPatientId(Long patientId);
	 
	 boolean existsByPatientMobile(String patientMobile);

	 }
