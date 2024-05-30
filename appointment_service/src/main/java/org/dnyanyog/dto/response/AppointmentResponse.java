package org.dnyanyog.dto.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"responseCode", "responseMessage", "data", "error"})

public class AppointmentResponse {

	private int responseCode;
    private String responseMessage;
    private AppointmentData data;
    private List<ValidationError> errors;

    // Getters and setters
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public AppointmentData getData() {
        return data;
    }

    public void setData(AppointmentData data) {
        this.data = data;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }
}
