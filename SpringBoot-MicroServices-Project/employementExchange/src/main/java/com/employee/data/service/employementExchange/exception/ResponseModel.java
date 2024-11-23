package com.employee.data.service.employementExchange.exception;

public class ResponseModel {
    private String responseMessage;
    private String status;


    public ResponseModel(String responseMessage, String status) {
        this.responseMessage = responseMessage;
        this.status = status;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
