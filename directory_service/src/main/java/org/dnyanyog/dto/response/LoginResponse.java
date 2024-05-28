package org.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"responseCode", "responseMessage"})
public class LoginResponse {
	
	private int ResponseCode;
	private String ResponseMessage;
  public int getResponseCode() {
  return ResponseCode;}
  public void setResponseCode(int responseCode) {
  ResponseCode = responseCode;}
  public String getResponseMessage() {
  return ResponseMessage;}
  public void setResponseMessage(String responseMessage) {
  ResponseMessage = responseMessage;}
	
}
