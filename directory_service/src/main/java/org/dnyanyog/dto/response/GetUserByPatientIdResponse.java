package org.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"responseCode", "responseMessage", "data", "error"})
public class GetUserByPatientIdResponse {

	private int ResponseCode;
	private String ResponseMessage;
	private GetUserByPatientIdData data;

	public GetUserByPatientIdData getData() {
  return data;}
  public void setData(GetUserByPatientIdData data) {
  this.data = data;}
  public int getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(int responseCode) {
		ResponseCode = responseCode;
	}
	public String getResponseMessage() {
		return ResponseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}
	

}
