package com.mse.mzad.user.internal.business.dtos;

public class BaseResponse<M, D> {
    private int statusCode;
    private M message;
    private D data;

    public BaseResponse(int statusCode, M message, D data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public M getMessage() {
        return message;
    }

    public void setMessage(M message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
