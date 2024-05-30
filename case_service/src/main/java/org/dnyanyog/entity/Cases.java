package org.dnyanyog.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "cases")
public class Cases {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String caseId;

  @Column private String patientId;

  @Column private String patientNameEnglish;

  @Column private String caseNumber;

  @Column private Date examinationDate;

  @Column private String symptons;

  @Column private String prescription;

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

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
