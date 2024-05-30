package org.dnyanyog.controller;


import org.dnyanyog.dto.request.CaseRequest;

import org.dnyanyog.dto.response.CaseResponse;

import org.dnyanyog.dto.response.DeleteCaseResponse;
import org.dnyanyog.service.CasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController 
{
	
	
		@Autowired
		CasesService caseService;

		@PostMapping(path = "api/v1/case/add")
		public ResponseEntity<CaseResponse> addCase(@RequestBody CaseRequest request) {
			return  caseService.addCase(request);
		}

		@GetMapping(path = "api/v1/case/{caseId}")
		public ResponseEntity<CaseResponse> SearchCaseByCaseId(@PathVariable String caseId)

		{
			return  caseService.SearchCaseByCaseId(caseId);

		}
		@GetMapping(path = "api/v1/case/{patientId}")
		public ResponseEntity<CaseResponse> SearchCaseByPatientId(@PathVariable String caseId)

		{
			return  caseService.SearchCaseByPatientId(caseId);

		}

		@DeleteMapping(path = "api/v1/case/delete/{caseId}")
		public ResponseEntity<DeleteCaseResponse> deleteCaseBycaseId(@PathVariable String caseId) 
		{
			return  caseService.deleteCaseByCaseId(caseId);

		}



}
