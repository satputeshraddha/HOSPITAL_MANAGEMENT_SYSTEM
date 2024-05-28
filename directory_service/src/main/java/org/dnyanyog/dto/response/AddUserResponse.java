package org.dnyanyog.dto.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"responseCode", "responseMessage", "data", "error"})
public class AddUserResponse {
  
    private int ResponseCode;
    private String ResponseMessage;
    private AddUserData data;
    private List<Error> error;

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
    
    public AddUserData getData() {
        return data;
    }
    
    public void setData(AddUserData data) {
        this.data = data;
    }
    
    public List<Error> getError() {
        return error;
    }
    
    public void setError(List<Error> error) {
        this.error = error;
    }

    public static class Error {
        private String message;

        public Error() {
        }

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}