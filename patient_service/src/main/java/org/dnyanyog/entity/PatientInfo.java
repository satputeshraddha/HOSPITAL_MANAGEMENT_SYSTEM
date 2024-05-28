package org.dnyanyog.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Component
@Entity
@Table
public class PatientInfo {
	
	
	@Id
	@GeneratedValue
	private Long patientId;
	@Column
	private String patientNameEnglish;

	@Column
	private String patientNameMarathi;

	@Column
	private String patientMobile;

	@Column
	private String patientGender;

	@Column
	private String address;

	@Column
	private Date birthDate;

	@Column
	private Date firstExaminationDate;
	
	@Column
	private String patientStatus = "ACTIVE";

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

  public String getAddress() {
  return address;}

  public void setAddress(String address) {
  this.address = address;}

  public Date getBirthDate() {
  return birthDate;}

  public void setBirthDate(Date birthDate) {
  this.birthDate = birthDate;}

  public Date getFirstExaminationDate() {
  return firstExaminationDate;}

  public void setFirstExaminationDate(Date firstExaminationDate) {
  this.firstExaminationDate = firstExaminationDate;}
}
