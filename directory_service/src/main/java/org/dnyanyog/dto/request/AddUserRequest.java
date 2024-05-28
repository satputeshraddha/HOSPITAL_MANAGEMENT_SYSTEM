package org.dnyanyog.dto.request;

import org.springframework.stereotype.Component;

@Component
public class AddUserRequest 
{
	
private String name;
private String email;
private String mobileNumber;
private String role;
private String password;
private String conformPassword;
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
