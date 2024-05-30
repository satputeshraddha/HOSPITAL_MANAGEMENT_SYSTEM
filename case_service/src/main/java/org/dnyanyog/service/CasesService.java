package org.dnyanyog.service;


import org.dnyanyog.dto.request.CaseRequest;
import org.dnyanyog.dto.response.CaseData;

import org.dnyanyog.dto.response.CaseResponse;
import org.dnyanyog.dto.response.DeleteCaseResponse;

import org.dnyanyog.entity.Cases;
import org.dnyanyog.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CasesService 
{
	@Autowired
	CaseRepository caseRepo;
	
	@Autowired
	CaseData caseData;
	
	@Autowired
	Cases cases;
	@Autowired
	CaseResponse caseResponse; 
	
	
	
	
	
	public ResponseEntity<CaseResponse> addCase(CaseRequest request)
	{
		if (caseRepo.findByCaseId(request.getCaseId()) != null) {

			CaseResponse caseResponse = new CaseResponse();
			caseResponse.setResponseCode(HttpStatus.CONFLICT.value());
			caseResponse.setResponseMessage("Case already exists");
			return ResponseEntity.status(HttpStatus.OK).body(caseResponse);
		}
		caseResponse = new CaseResponse();
		caseResponse.setData(new CaseData());

		cases = new Cases();
		cases.setCaseId(request.getCaseId());
		cases.setCaseNumber(request.getCaseNumber());
		cases.setExaminationDate(request.getExaminationDate());
		cases.setPatientId(request.getPatientId());
		cases.setPatientNameEnglish(request.getPatientNameEnglish());
		cases.setPrescription(request.getPrescription());
		cases.setSymptons(request.getSymptons());
		cases = caseRepo.saveAndFlush(cases);

		caseResponse.setResponseCode(HttpStatus.CREATED.value());
		caseResponse.setResponseMessage("Case  created successfully !!!");
		caseResponse.getData().setCaseNumber(cases.getCaseNumber());
		caseResponse.getData().setExaminationDate(cases.getExaminationDate());
		caseResponse.getData().setPatientId(cases.getPatientId());
		caseResponse.getData().setPatientNameEnglish(cases.getPrescription());
		caseResponse.getData().setPrescription(cases.getPrescription());
		caseResponse.getData().setSymptons(cases.getSymptons());
		caseResponse.getData().setCaseId(cases.getCaseId());
		return ResponseEntity.status(HttpStatus.CREATED).body(caseResponse);

	}
	
	public ResponseEntity<CaseResponse> SearchCaseByCaseId(String caseId) {
		Cases cases = caseRepo.findByCaseId(caseId);
		if (cases == null) {
			CaseResponse getCaseByCaseId = new CaseResponse();
			getCaseByCaseId.setResponseCode(HttpStatus.NOT_FOUND.value());
			getCaseByCaseId.setResponseMessage("Case not found");
			return ResponseEntity.status(HttpStatus.OK).body(getCaseByCaseId);
		}
		CaseResponse casePaperResponse = new CaseResponse();
		caseResponse.setResponseCode(HttpStatus.OK.value());
		caseResponse.setResponseMessage("Case found");
		casePaperResponse.setData(new CaseData());

		caseResponse.getData().setCaseId(cases.getCaseId());
		caseResponse.getData().setCaseNumber(cases.getCaseNumber());
		caseResponse.getData().setPatientId(cases.getPatientId());
		caseResponse.getData().setPatientNameEnglish(cases.getPatientNameEnglish());
		caseResponse.getData().setPrescription(cases.getPrescription());
		caseResponse.getData().setSymptons(cases.getSymptons());
		caseResponse.getData().setExaminationDate(cases.getExaminationDate());
		return ResponseEntity.status(HttpStatus.OK).body(caseResponse);
		
	}
	
	

	public ResponseEntity<CaseResponse> SearchCaseByPatientId(String patientId) {
		Cases cases = caseRepo.findByPatientId(patientId);
		if (cases == null) {
			CaseResponse getCaseByPatientId = new CaseResponse();
			getCaseByPatientId.setResponseCode(HttpStatus.NOT_FOUND.value());
			getCaseByPatientId.setResponseMessage("Case not found");
			return ResponseEntity.status(HttpStatus.OK).body(getCaseByPatientId);
		}
		CaseResponse casePaperResponse = new CaseResponse();
		caseResponse.setResponseCode(HttpStatus.OK.value());
		caseResponse.setResponseMessage("Case found");
		casePaperResponse.setData(new CaseData());

		caseResponse.getData().setCaseId(cases.getCaseId());
		caseResponse.getData().setCaseNumber(cases.getCaseNumber());
		caseResponse.getData().setPatientId(cases.getPatientId());
		caseResponse.getData().setPatientNameEnglish(cases.getPatientNameEnglish());
		caseResponse.getData().setPrescription(cases.getPrescription());
		caseResponse.getData().setSymptons(cases.getSymptons());
		caseResponse.getData().setExaminationDate(cases.getExaminationDate());
		return ResponseEntity.status(HttpStatus.OK).body(caseResponse);
		
	}

	public ResponseEntity<DeleteCaseResponse> deleteCaseByCaseId(String caseId) {

		Cases cases = caseRepo.findByCaseId(caseId);

		if (cases == null) {
			DeleteCaseResponse deleteCaseResponse = new DeleteCaseResponse();
			deleteCaseResponse.setResponseCode(HttpStatus.OK.value());
			deleteCaseResponse.setResponseMessage("Case not found");
			return ResponseEntity.status(HttpStatus.OK).body(deleteCaseResponse);
		}

		caseRepo.delete(cases);

		DeleteCaseResponse deleteCaseResponse = new DeleteCaseResponse();
		deleteCaseResponse.setResponseCode(HttpStatus.OK.value());
		deleteCaseResponse.setResponseMessage("Case Deleted Successfully");

		return ResponseEntity.status(HttpStatus.OK).body(deleteCaseResponse);
	}


}

