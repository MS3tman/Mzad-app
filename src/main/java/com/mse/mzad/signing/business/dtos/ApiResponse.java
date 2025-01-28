package com.mse.mzad.signing.business.dtos;

public class ApiResponse<T> {
    private int status_code;
    private String message;
    private T data;

    public ApiResponse(int status_code, String message, T data) {
        this.message = message;
        this.data = data;
        this.status_code = status_code;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
