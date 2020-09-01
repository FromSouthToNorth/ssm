package com.hy.ssm.enums;

public enum ResultEnums {

    SUCCESS(200),
    ERROR(404),
    EXCEPTION(500);
    private final Integer statusCode;

    public Integer getStatusCode() {
        return statusCode;
    }

    ResultEnums(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
