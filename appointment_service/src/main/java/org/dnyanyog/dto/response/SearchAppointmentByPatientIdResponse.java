package org.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"responseCode", "responseMessage", "data", "error"})
public class SearchAppointmentByPatientIdResponse {

  private int ResponseCode;
  private String ResponseMessage;
  private SearchAppointmentByPatientIdData data;

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

  public SearchAppointmentByPatientIdData getData() {
    return data;
  }

  public void setData(SearchAppointmentByPatientIdData data) {
    this.data = data;
  }
}
