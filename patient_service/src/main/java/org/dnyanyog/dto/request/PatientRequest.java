package org.dnyanyog.dto.request;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class PatientRequest {
	
	private Long patientId;
		
		private String patientNameEnglish;

		private String patientNameMarathi;

		private String patientMobile;

		private String patientGender;
	    
		private Date birthDate; 
		
		private Date firstExaminationDate;
		
		private String address;
		private String patientStatus;


    public String getPatientStatus() {
    return patientStatus;}

    public void setPatientStatus(String patientStatus) {
    this.patientStatus = patientStatus;}

  public Long getPatientId() {
    return patientId;}

    public void setPatientId(Long patientId) {
    this.patientId = patientId;}

    public String getPatientNameEnglish() {
    return patientNameEnglish;}

    public void setPatientNameEnglish(String patientNameEnglish) {
    this.patientNameEnglish = patientNameEnglish;}

    public String getPatientNameMarathi() {
    return patientNameMarathi;}

    public void setPatientNameMarathi(String patientNameMarathi) {
    this.patientNameMarathi = patientNameMarathi;}

    public String getPatientMobile() {
    return patientMobile;}

    public void setPatientMobile(String patientMobile) {
    this.patientMobile = patientMobile;}

    public String getPatientGender() {
    return patientGender;}

    public void setPatientGender(String patientGender) {
    this.patientGender = patientGender;}

    public Date getBirthDate() {
    return birthDate;}

    public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;}

    public Date getFirstExaminationDate() {
    return firstExaminationDate;}

    public void setFirstExaminationDate(Date firstExaminationDate) {
    this.firstExaminationDate = firstExaminationDate;}

    public String getAddress() {
    return address;}

    public void setAddress(String address) {
    this.address = address;}
}
