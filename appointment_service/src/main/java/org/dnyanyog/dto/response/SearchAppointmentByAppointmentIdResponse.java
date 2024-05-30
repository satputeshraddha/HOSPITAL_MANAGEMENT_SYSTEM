package org.dnyanyog.dto.response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"responseCode", "responseMessage", "data", "error"})
public class SearchAppointmentByAppointmentIdResponse {

  private int ResponseCode;
  private String ResponseMessage;
  private SearchAppointmentByAppointmentIdData data;

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

  public SearchAppointmentByAppointmentIdData getData() {
    return data;
  }

  public void setData(SearchAppointmentByAppointmentIdData data) {
    this.data = data;
  }
}
