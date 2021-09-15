package com.example.crm.exception;


public class NotFindAnyOneException extends RuntimeException{

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private NotFindAnyOneException() {
    }

    public NotFindAnyOneException( int code,String message) {
        super(message);
        this.code = code;
    }
}
