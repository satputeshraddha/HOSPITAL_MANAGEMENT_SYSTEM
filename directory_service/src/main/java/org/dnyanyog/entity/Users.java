package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
@Component
public class Users 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String mobileNumber;
	@Column
	private String role;
	@Column
	private String password;
	@Column
	private String conformPassword;
	@Column
	private int failedLoginAttempts;


 
  public int getFailedLoginAttempts() {
  return failedLoginAttempts;}
  public void setFailedLoginAttempts(int failedLoginAttempts) {
  this.failedLoginAttempts = failedLoginAttempts;}
public long getPatientId() {
  return patientId;}
  public void setPatientId(long patientId) {
  this.patientId = patientId;}
public String getName() {
  return name;}
  public void setName(String name) {
  this.name = name;}
  public String getEmail() {
  return email;}
  public void setEmail(String email) {
  this.email = email;}
  public String getMobileNumber() {
  return mobileNumber;}
  public void setMobileNumber(String mobileNumber) {
  this.mobileNumber = mobileNumber;}
  public String getRole() {
  return role;}
  public void setRole(String role) {
  this.role = role;}
  public String getPassword() {
  return password;}
  public void setPassword(String password) {
  this.password = password;}
  public String getConformPassword() {
  return conformPassword;}
  public void setConformPassword(String conformPassword) {
  this.conformPassword = conformPassword;}
	
	
	
}
