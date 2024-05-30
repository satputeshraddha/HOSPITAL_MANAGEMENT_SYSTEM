package org.dnyanyog.dto.request;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CaseRequest {

  private String caseId;
  private String patientNameEnglish;
  private String patientId;
  private String caseNumber;
  private Date examinationDate;
  private String symptons;
  private String prescription;

  public String getCaseId() {
    return caseId;
  }

  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public String getPatientNameEnglish() {
    return patientNameEnglish;
  }

  public void setPatientNameEnglish(String patientNameEnglish) {
    this.patientNameEnglish = patientNameEnglish;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public Date getExaminationDate() {
    return examinationDate;
  }

  public void setExaminationDate(Date examinationDate) {
    this.examinationDate = examinationDate;
  }

  public String getSymptons() {
    return symptons;
  }

  public void setSymptons(String symptons) {
    this.symptons = symptons;
  }

  public String getPrescription() {
    return prescription;
  }

  public void setPrescription(String prescription) {
    this.prescription = prescription;
  }
}
