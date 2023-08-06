package com.example.employee.dto;

public class ResponseDto {

    private Object response;
    private boolean errFlag;
    private boolean warnFlag;
    private String message;
    private int statusCode;

    public ResponseDto(boolean errFlag, String message) {
        this.errFlag = errFlag;
        this.message = message;
    }

    public ResponseDto(boolean errFlag, int statusCode, String message) {
        this.errFlag = errFlag;
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResponseDto(boolean errFlag, String message, int statusCode) {
        this.errFlag = errFlag;
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResponseDto(boolean errFlag, int statusCode) {
        this.errFlag = errFlag;
        this.statusCode = statusCode;
    }

    public ResponseDto(int statusCode, boolean warnFlag) {
        this.warnFlag = warnFlag;
        this.statusCode = statusCode;
    }

    public ResponseDto(boolean errFlag, boolean warnFlag, String message) {
        this.errFlag = errFlag;
        this.warnFlag = warnFlag;
        this.message = message;
    }

    public ResponseDto(Object response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
    }

    public ResponseDto(Object response) {
        this.response = response;
    }

    public ResponseDto() {
        // Default constructor
    }

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public boolean isErrFlag() {
		return errFlag;
	}

	public void setErrFlag(boolean errFlag) {
		this.errFlag = errFlag;
	}

	public boolean isWarnFlag() {
		return warnFlag;
	}

	public void setWarnFlag(boolean warnFlag) {
		this.warnFlag = warnFlag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

    // Getters and setters
}
