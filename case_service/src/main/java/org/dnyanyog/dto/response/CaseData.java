package org.dnyanyog.dto.response;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CaseData 
{
	
	private String patientNameEnglish;
	 private String patientId;
	 private String caseId;
	 public String getCaseId() {
  return caseId;}
  public void setCaseId(String caseId) {
  this.caseId = caseId;}
  private String caseNumber;
	 private Date examinationDate;
	 private String symptons;
	 private String prescription;
  public String getPatientId() {
  return patientId;}
  public void setPatientId(String patientId) {
  this.patientId = patientId;}
  public String getCaseNumber() {
  return caseNumber;}
  public void setCaseNumber(String caseNumber) {
  this.caseNumber = caseNumber;}
public String getPatientNameEnglish() {
  return patientNameEnglish;}
  public void setPatientNameEnglish(String patientNameEnglish) {
  this.patientNameEnglish = patientNameEnglish;}

  public Date getExaminationDate() {
  return examinationDate;}
  public void setExaminationDate(Date examinationDate) {
  this.examinationDate = examinationDate;}
  public String getSymptons() {
  return symptons;}
  public void setSymptons(String symptons) {
  this.symptons = symptons;}
  public String getPrescription() {
  return prescription;}
  public void setPrescription(String prescription) {
  this.prescription = prescription;}
	
}
