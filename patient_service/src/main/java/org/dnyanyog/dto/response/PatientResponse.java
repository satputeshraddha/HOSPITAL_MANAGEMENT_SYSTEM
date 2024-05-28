package org.dnyanyog.dto.response;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PatientResponse {
	
	  private int responseCode;
	    private String responseMessage;
	    private PatientData data;
	    private List<ValidationError> errors;
	    private List<PatientData> dataList;

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

	    public PatientData getData() {
	        return data;
	    }

	    public void setData(PatientData data) {
	        this.data = data;
	    }

	    public List<PatientData> getDataList() {
	        return dataList;
	    }

	    public void setDataList(List<PatientData> dataList) {
	        this.dataList = dataList;
	    }

	    public List<ValidationError> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<ValidationError> errors) {
	        this.errors = errors;
	    }

	    public static class ValidationError {
	        private String field;
	        private String message;

	        public ValidationError(String field, String message) {
	            this.field = field;
	            this.message = message;
	        }

	        public String getField() {
	            return field;
	        }

	        public void setField(String field) {
	            this.field = field;
	        }

	        public String getMessage() {
	            return message;
	        }

	        public void setMessage(String message) {
	            this.message = message;
	        }
	    
	  }
}