package org.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

@Component
public class UserData 
{
private long patientId;

private String name;
private String email;
private String mobileNumber;
private String role;
private String password;
private String conformPassword;

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
