package org.dnyanyog.repository;
import java.util.List;


import org.dnyanyog.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Cases,Long>
{
	
	Cases findByCaseId(String caseId);
	Cases findByPatientId(String patientId);
	 Cases deleteByCaseId(String caseId);
	
}
